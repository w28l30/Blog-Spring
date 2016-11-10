package blog.mapper;

import blog.model.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by W28L30 on 2016/10/26.
 */
@Mapper
public interface UserMapper {
    public void saveUser(User user);

    public User findUserByEmail(String user);
}
