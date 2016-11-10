package blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by W28L30 on 2016/10/18.
 */
@Controller
public class Upload {
    @RequestMapping(value = "/upload")
    public String upload() {
        return "upload";
    }
}
