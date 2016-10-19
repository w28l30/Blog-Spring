package hello.controller;

import hello.model.Comment;
import hello.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

/**
 * Created by W28L30 on 2016/10/12.
 */
@Controller
@RequestMapping("/posts")
public class PostController {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String get(@PathVariable("id") long id, Model model) {
        model.addAttribute("post", this.jdbcTemplate.queryForObject(
                "select * from post where id = ?", new Object[]{id},
                (rs, rowNum) -> new Post(rs.getLong("id"), rs.getString("title"), rs.getString("content"), rs.getDate("created"))));

        model.addAttribute("comments", this.jdbcTemplate.query(
                "select * from comment where post = ?", new Object[]{id},
                (rs, rowNum) -> new Comment(rs.getLong("id"), rs.getString("content"), rs.getDate("created"), rs.getLong("post"))));

        return "post";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String showCreatePage(Model model, HttpSession session) {
        if (session.getAttribute("root") == null) {
            return "redirect:/";
        }

        model.addAttribute("post", new Post());
        return "create";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String create(@Valid Post post, BindingResult result) {
        if (result.hasErrors()) {
            return "create";
        }
        jdbcTemplate.update("insert into post(title, content, created) values (?, ?, ?)", post.getTitle(), post.getContent(), post.getCreated());
        Long id = jdbcTemplate.queryForObject("select last_insert_id()", Long.class);

        return "redirect:/posts/" + id;
    }
}
