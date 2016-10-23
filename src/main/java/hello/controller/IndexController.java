package hello.controller;

import hello.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
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
    private PostService postService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String index(Model model) {
//        model.addAttribute("posts", this.jdbcTemplate.query(
//                "select * from post",
//                (rs, rowNum) -> new Post(rs.getLong("id"), rs.getString("title"), rs.getString("content"), rs.getDate("created"))));
        model.addAttribute("posts", postService.getAll());
        return "index";
    }
}
