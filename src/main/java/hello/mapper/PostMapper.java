package hello.mapper;

import hello.model.Comment;
import hello.model.Post;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by W28L30 on 2016/10/22.
 */
@Mapper
public interface PostMapper {


    @Select("SELECT post.id, post.title, post.content, post.created FROM post")
    @Results(value = {
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "title", column = "title"),
            @Result(property = "content", column = "content"),
            @Result(property = "created", column = "created"),
            @Result(property = "comments", javaType = List.class, column = "id", many = @Many(select = "hello.mapper.CommentMapper.getComments"))
    })
    List<Post> getAllPost();

    @Select("SELECT post.id, post.title, post.content, post.created FROM post WHERE post.id = #{id}")
        @Results(value = {
                @Result(id = true, property = "id", column = "id"),
                @Result(property = "title", column = "title"),
                @Result(property = "content", column = "content"),
                @Result(property = "created", column = "created"),
                @Result(property = "comments", javaType = List.class, column = "id", many = @Many(select = "hello.mapper.CommentMapper.getComments"))
        })
    Post getPostById(long id);

    @Insert("INSERT INTO post (title, content, created) VALUES (#{title}, #{content}, #{created})")
    void savePost(Post post);
}
