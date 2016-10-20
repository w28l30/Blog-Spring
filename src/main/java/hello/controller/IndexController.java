package hello.controller;

import hello.model.Post;
import hello.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by W28L30 on 2016/10/18.
 */
@Controller
public class IndexController {
    @Autowired
    private PostRepository postRepository;
//    private JdbcTemplate jdbcTemplate;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String index(Model model) {
//        model.addAttribute("posts", this.jdbcTemplate.query(
//                "select * from post",
//                (rs, rowNum) -> new Post(rs.getLong("id"), rs.getString("title"), rs.getString("content"), rs.getDate("created"))));
        model.addAttribute("posts", postRepository.findAll());
        return "index";
    }
}
