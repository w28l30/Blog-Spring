package hello.controller;

import hello.model.Post;
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
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String get(@PathVariable("id") long id, Model model) {
        model.addAttribute("post", Data.getById(id));
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
        Post p = Data.add(post);

        return "redirect:/posts/" + p.getId();
    }
}
