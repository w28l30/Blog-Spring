package Test;

import hello.Application;
import hello.model.User;
import hello.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by W28L30 on 2016/10/27.
 */
@org.junit.runner.RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class TestUser {
    @Autowired
    private UserService userService;

    @Test
    public void testAdd() {
        User user = new User("yysgkgtc511@gmail.com", "Thechosen1", User.ROLE_ADMIN);
        user.prePersist();
        userService.saveUser(user);
    }
}
