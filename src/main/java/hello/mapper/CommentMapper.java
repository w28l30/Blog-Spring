package hello.mapper;

import hello.model.Comment;
import hello.model.Post;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;

import java.util.List;

/**
 * Created by W28L30 on 2016/10/22.
 */
@Mapper
public interface CommentMapper {

    @Insert("INSERT INTO COMMENT (content, created, post_id) VALUES (#{content}, #{created}, #{post.id})")
    void saveComment(Comment comment);
}
