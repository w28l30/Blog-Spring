package blog.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import blog.model.Post;
import blog.service.AppSetting;
import blog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by W28L30 on 2016/10/18.
 */
@Controller
public class IndexController {
    @Autowired
    private PostService postService;

    @Autowired
    private AppSetting appSetting;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String index(@RequestParam(defaultValue = "1") int page, Model model) {
//        model.addAttribute("posts", this.jdbcTemplate.query(
//                "select * from post",
//                (rs, rowNum) -> new Post(rs.getLong("id"), rs.getString("title"), rs.getString("content"), rs.getDate("created"))));
        PageHelper.startPage(page, 10);
        List<Post> posts = postService.getAll();
        PageInfo pageInfo = new PageInfo(posts);

        model.addAttribute("posts", posts);
        model.addAttribute("totalPages", pageInfo.getPages());
        model.addAttribute("page", page);
        model.addAttribute("appSetting", appSetting);
        return "index1";
    }
}
