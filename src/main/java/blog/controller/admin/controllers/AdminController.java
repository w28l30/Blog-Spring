package blog.controller.admin.controllers;

import blog.model.Post;
import blog.model.support.SettingForm;
import blog.service.AppSetting;
import blog.service.PostService;
import blog.utils.DTOUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by W28L30 on 2016/11/5.
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AppSetting appSetting;

    @Autowired
    private PostService postService;

    @RequestMapping(value = "")
    public String index(@RequestParam(defaultValue = "1") int page, Model model) {
        PageHelper.startPage(page, appSetting.getPageSize());
        List<Post> posts = postService.getAll();
        PageInfo pageInfo = new PageInfo(posts);

        model.addAttribute("appSetting", appSetting);
        model.addAttribute("totalPages", pageInfo.getPages());
        model.addAttribute("page", page);
        model.addAttribute("posts", posts);

        return "admin/posts/index";
    }

    @RequestMapping(value = "setting")
    public String setting(Model model) {
        SettingForm settingForm = DTOUtil.map(appSetting, SettingForm.class);
        model.addAttribute("appSetting", appSetting);
        model.addAttribute("settingForm", settingForm);
        return "admin/home/setting";
    }

    @RequestMapping(value = "setting", method = RequestMethod.POST)
    public String updateSettings(@Valid SettingForm settingsForm, Errors errors, Model model){
        if (errors.hasErrors()){
            return "admin/setting";
        } else {
            appSetting.setSiteName(settingsForm.getSiteName());
            appSetting.setSiteSlogan(settingsForm.getSiteSlogan());
            appSetting.setPageSize(settingsForm.getPageSize());
            appSetting.setAboutMe(settingsForm.getAboutMe());

            return "redirect:setting";
        }
    }
}
