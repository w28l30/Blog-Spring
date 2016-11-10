package blog.controller;

import com.google.common.io.ByteStreams;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * Created by W28L30 on 2016/10/18.
 */
@Controller
@RequestMapping("/avatar")
public class AvatarController {
    private Resource resource = new ClassPathResource("static/img/catty.jpeg");

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public byte[] avatar() throws IOException {
        return Data.avatar == null ? ByteStreams.toByteArray(resource.getInputStream()) : Data.avatar;
    }

    @RequestMapping(method = RequestMethod.POST)
    public String upload(@RequestParam("file") MultipartFile file) throws IOException {
        Data.avatar = file.getBytes();
        return "redirect:/upload";
    }
}
