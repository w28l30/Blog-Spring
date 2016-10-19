package hello.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.servlet.http.HttpSession;
import java.util.Optional;

/**
 * Created by W28L30 on 2016/10/18.
 */
@Controller
@RequestMapping("/login")
public class LoginController extends WebMvcConfigurerAdapter {
    public static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @RequestMapping(method = RequestMethod.GET)
    public String loginPage(@RequestParam("next") Optional<String> next) {
        return "login";
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        @RequestParam("next") Optional<String> next,
                        HttpSession session, Model model) {
        logger.info("next = {}", next.orElse("/"));
        if ("admin".equals(username) && "password".equals(password)) {
            logger.info("login successfully");
            session.setAttribute("root", true);
            return "redirect:".concat(next.orElse("/"));
        }
        model.addAttribute("fail", true);
        return "login";
    }
}
