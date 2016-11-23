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
        PageHelper.startPage(page, appSetting.getPageSize());
        List<Post> posts = postService.getAll();
        PageInfo pageInfo = new PageInfo(posts);

        if (pageInfo.isIsLastPage()) {
            model.addAttribute("isLast", true);
        } else {
            model.addAttribute("isLast", false);
        }

        if (pageInfo.isIsFirstPage()) {
            model.addAttribute("isFirst", true);
        } else {
            model.addAttribute("isFirst", false);
        }

        model.addAttribute("posts", posts);
        model.addAttribute("totalPages", pageInfo.getPages());
        model.addAttribute("page", page);
        model.addAttribute("appSetting", appSetting);
        return "index1";
    }
    @RequestMapping(value = "/contact")
    public String contact(Model model) {
        model.addAttribute("appSetting", appSetting);
        return "contact";
    }

    @RequestMapping(value = "/about")
    public String about(Model model) {
        model.addAttribute("appSetting", appSetting);
        return "about";
    }

}
