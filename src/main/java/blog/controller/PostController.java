package blog.controller;

import blog.model.Comment;
import blog.model.Post;
import blog.service.AppSetting;
import blog.service.CommentService;
import blog.service.PostService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 * Created by W28L30 on 2016/10/12.
 */
@Controller
@RequestMapping("/posts")
public class PostController {

    public static final Logger logger = LoggerFactory.getLogger(PostController.class);

    @Autowired
    private AppSetting appSetting;
    @Autowired
    private PostService postService;
    @Autowired
    private CommentService commentService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String get(@PathVariable("id") long id, Model model) {
        Post post = postService.getById(id);
        logger.info("post comments size = {}", post.getComments().size());
        logger.info("post tags size = {}", post.getTags().size());

        model.addAttribute("post", post);
        model.addAttribute("appSetting", appSetting);

        return "post1";
    }

    @RequestMapping(value = "/{postId}/comments", method = RequestMethod.POST)
    public String createComment(@PathVariable("postId") long id, @Valid Comment comment, BindingResult result) {
        if (result.hasErrors()) {
            return "redirect:/posts/" + id;
        }
        logger.info("comment = {}, {}", comment.getId(), comment.getContent());
        Post post = postService.getById(id);
        comment.setPost(post);
        commentService.saveComment(comment);
        return "redirect:/posts/{postId}";
    }

    @RequestMapping(value = "/previousPage/{postId}", method = RequestMethod.GET)
    public String previousPage(@PathVariable("postId") long id) {
        Post previousPost = postService.getById(id - 1);
        if (previousPost != null) {
            return "redirect:/posts/" + (id - 1);
        }
        return "redirect:/posts/{postId}";
    }

    @RequestMapping(value = "/nextPage/{postId}", method = RequestMethod.GET)
    public String nextPage(@PathVariable("postId") long id) {
        Post previousPost = postService.getById(id + 1);
        if (previousPost != null) {
            return "redirect:/posts/" + (id + 1);
        }
        return "redirect:/posts/{postId}";
    }
}
