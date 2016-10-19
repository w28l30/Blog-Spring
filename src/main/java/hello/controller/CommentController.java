package hello.controller;

import hello.model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.Date;

/**
 * Created by W28L30 on 2016/10/19.
 */

@Controller
@RequestMapping(value = "/comments")
public class CommentController {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String create(@Valid Comment comment, BindingResult result) {
        if (result.hasErrors()) {
            return "redirect:/posts/" + comment.getPost();
        }
        this.jdbcTemplate.update("insert into comment(content, post ,created) values(?, ?, ?);", comment.getContent(), comment.getPost(), new Date());
        return "redirect:/posts/" + comment.getPost();
    }
}
