package blog.controller.admin.controllers;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import blog.model.Post;
import blog.model.Tag;
import blog.model.support.PostForm;
import blog.service.AppSetting;
import blog.service.PostService;
import blog.utils.DTOUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;
import java.util.Set;

/**
 * Created by W28L30 on 2016/11/5.
 */
@RequestMapping(value = "/admin/posts")
@Controller("adminPostController")
public class PostController {

    public static final Logger logger = LoggerFactory.getLogger(blog.controller.PostController.class);

    private static final int PAGE_SIZE = 20;

    @Autowired
    private PostService postService;

    @Autowired
    private AppSetting appSetting;

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String showCreatePage(Model model) {
        model.addAttribute("postForm", new PostForm());
        model.addAttribute("appSetting", appSetting);
        return "admin/posts/create";
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
        PageInfo pageInfo = new PageInfo(posts);

        model.addAttribute("appSetting", appSetting);
        model.addAttribute("totalPages", pageInfo.getPages());
        model.addAttribute("page", page);
        model.addAttribute("posts", posts);

        return "admin/posts/index";
    }

    @RequestMapping(value = "{postId:[0-9]+}/delete", method = {RequestMethod.DELETE, RequestMethod.POST})
    public String deletePost(@PathVariable Long postId) {
        postService.deletePost(postId);
        logger.info("Delete Post {}", postId);
        return "redirect:/admin/posts";
    }

    @RequestMapping(value = "{postId:[0-9]+}/edit", method = RequestMethod.GET)
    public String editPost(@PathVariable Long postId, Model model) {
        Post post = postService.getById(postId);
        PostForm postForm = DTOUtil.map(post, PostForm.class);

        String tags = postService.getTagNames(post.getTags());
        logger.info("Tag {}", tags);
        postForm.setTags(tags);

        model.addAttribute("post", post);
        model.addAttribute("postForm", postForm);
        model.addAttribute("appSetting", appSetting);

        return "admin/posts/edit";
    }

    @RequestMapping(value = "{postId:[0-9]+}", method = {RequestMethod.PUT, RequestMethod.POST})
    public String updatePost(@PathVariable Long postId, @Valid PostForm postForm, BindingResult bindingResult, Model model) {

        Post post = postService.getById(postId);
        DTOUtil.mapTo(postForm, post);
        Set<Tag> tagSet = postService.parseTagNames(postForm.getTags());
        post.setTags(tagSet);

        postService.deletePostTags(postId);
        postService.update(post);
        postService.insertPostTags(post);

        return "redirect:/admin/posts";
    }
}
