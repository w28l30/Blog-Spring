package hello.controller.admin.controllers;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import hello.model.Post;
import hello.model.support.PostForm;
import hello.service.PostService;
import hello.utils.DTOUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

/**
 * Created by W28L30 on 2016/11/5.
 */
@RequestMapping(value = "/admin/posts")
@Controller("adminPostController")
public class PostController {

    public static final Logger logger = LoggerFactory.getLogger(hello.controller.PostController.class);

    private static final int PAGE_SIZE = 20;

    @Autowired
    private PostService postService;

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String showCreatePage(Model model, HttpSession session) {
//        if (session.getAttribute("root") == null) {
//            return "redirect:/";
//        }

        model.addAttribute("postForm", new PostForm());
        return "create";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String create(@Valid PostForm postForm, BindingResult result) {
        if (result.hasErrors()) {
            return "create";
        }
        Post post = DTOUtil.map(postForm, Post.class);
        post.setTags(postService.parseTagNames(postForm.getTags()));
        postService.save(post);
        postService.insertPostTags(post);

        return "redirect:/posts/" + post.getId();
    }

    @RequestMapping(value = "")
    public String index(@RequestParam(defaultValue = "1") int page, Model model) {
        PageHelper.startPage(page, PAGE_SIZE);
        List<Post> posts = postService.getAll();
//        logger.info("page {}", page);
        PageInfo pageInfo = new PageInfo(posts);

        model.addAttribute("totalPages", pageInfo.getPages());
        model.addAttribute("page", page);
        model.addAttribute("posts", posts);

        return "admin/posts/index";
    }
}
