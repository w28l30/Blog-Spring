package hello.controller.admin.controllers;

import hello.model.support.SettingForm;
import hello.service.AppSetting;
import hello.utils.DTOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 * Created by W28L30 on 2016/11/5.
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AppSetting appSetting;

    @RequestMapping(value = "")
    public String index(Model model) {
        model.addAttribute("appSetting", appSetting);
        return "admin/home/index";
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

            return "redirect:setting";
        }
    }
}
