package blog.service;

/**
 * Created by W28L30 on 2016/10/27.
 */
public interface SecurityService {
    String findLoggedInUsername();
    void autoLogin(String username, String password);
}
