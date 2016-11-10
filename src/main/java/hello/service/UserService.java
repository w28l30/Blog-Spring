package hello.service;

import hello.model.User;
import org.springframework.stereotype.Service;

/**
 * Created by W28L30 on 2016/10/27.
 */
@Service
public interface UserService {
    public User findUserByEmail(String username);
    public void saveUser(User user);
}
