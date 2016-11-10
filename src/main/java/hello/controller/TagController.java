package hello.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import hello.model.Post;
import hello.model.Tag;
import hello.service.AppSetting;
import hello.service.PostService;
import hello.service.TagService;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by W28L30 on 2016/11/4.
 */
@Controller
@RequestMapping("/tags")
public class TagController {
    @Autowired
    private TagService tagService;

    @Autowired
    private PostService postService;

    @Autowired
    private AppSetting appSetting;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("tagsWithCount", postService.countPostsByTags());
        model.addAttribute("appSetting", appSetting);
        return "tags/index";
    }

    @RequestMapping(value = "{tagName}", method = RequestMethod.GET)
    public String showTag(@PathVariable String tagName, @RequestParam(defaultValue = "1") int page, Model model) throws NotFoundException {
        Tag tag = tagService.findOrCreateByName(tagName);
        if (tag == null) {
            throw new NotFoundException("Tag " + tagName + " is not found.");
        }

        PageHelper.startPage(page, 10);

        List<Post> posts = postService.getPostsByTag(tagName);
        PageInfo pageInfo = new PageInfo(posts);

        model.addAttribute("appSetting", appSetting);
        model.addAttribute("tag", tag);
        model.addAttribute("posts", posts);
        model.addAttribute("page", page);
        model.addAttribute("pageSize", pageInfo.getPages());

        return "tags/show";
    }
}
