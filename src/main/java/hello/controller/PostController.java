package hello.controller;

import hello.model.Comment;
import hello.model.Post;
import hello.service.CommentService;
import hello.service.PostService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

    public static final Logger logger = LoggerFactory.getLogger(PostController.class);

    @Autowired
    private PostService postService;
    @Autowired
    private CommentService commentService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String get(@PathVariable("id") long id, Model model) {
        Post post = postService.getById(id);
        logger.info("post comments size = {}", post.getComments().size());
        model.addAttribute("post", post);

        return "post";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String showCreatePage(Model model, HttpSession session) {
//        if (session.getAttribute("root") == null) {
//            return "redirect:/";
//        }

        model.addAttribute("post", new Post());
        return "create";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String create(@Valid Post post, BindingResult result) {
        if (result.hasErrors()) {
            return "create";
        }
        postService.save(post);

        return "redirect:/posts/" + post.getId();
    }

    @RequestMapping(value = "/{postId}/comments", method = RequestMethod.POST)
    public String createComment(@PathVariable("postId") long id, @Valid Comment comment, BindingResult result) {
        if (result.hasErrors()) {
            return "redirect:/posts/" + comment.getPost().getId();
        }
        logger.info("comment = {}, {}", comment.getId(), comment.getContent());
        Post post = postService.getById(id);
        comment.setPost(post);
        commentService.saveComment(comment);
        return "redirect:/posts/{postId}";
    }
}
