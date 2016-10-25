package hello.mapper;

import hello.model.Comment;
import hello.model.Post;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by W28L30 on 2016/10/22.
 */
@Mapper
public interface CommentMapper {

//    @Insert("INSERT INTO COMMENT (content, created, post_id) VALUES (#{content}, #{created}, #{post.id})")
    void saveComment(Comment comment);


//    @Select("SELECT comment.id, comment.content, comment.created FROM post, comment WHERE comment.post_id = post.id AND post.id = #{id}")
//    @Results (value = {
//            @Result(id = true, column = "id", property = "id"),
//            @Result(column = "content", property = "content"),
//            @Result(column = "created", property = "created"),
//    })
//    List<Comment> getComments(long id);
}
