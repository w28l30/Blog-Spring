package hello.controller;

import hello.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by W28L30 on 2016/11/4.
 */
@Controller
@RequestMapping("/tags")
public class TagController {
    @Autowired
    private TagService tagService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String index(Model model) {
//        model.addAttribute("tags", );
        return "tags/index";
    }
}
