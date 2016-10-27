package hello.service;

import hello.model.User;

/**
 * Created by W28L30 on 2016/10/27.
 */
public interface UserService {
    public User findUserByEmail(String username);
    public void saveUser(User user);
}
