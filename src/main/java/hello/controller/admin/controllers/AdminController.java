package hello.controller.admin.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by W28L30 on 2016/11/5.
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

    @RequestMapping("")
    public String index() {
        return "admin/index";
    }
}
