package blog.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by W28L30 on 2016/10/24.
 */
@Getter @Setter
public class User extends BaseModel {
    public static final String ROLE_ADMIN = "ROLE_ADMIN";
    public static final String ROLE_USER = "ROLE_USER";

    private String email;

    private String password;

    private String role = ROLE_USER;

    private List<Post> posts = new ArrayList<>();

    public User() {}

    public User(String email, String password, String role) {
        this.email = email;
        this.password = password;
        this.role = role;
    }
}
