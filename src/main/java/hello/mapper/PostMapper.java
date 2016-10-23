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
            @Result(property = "comments", javaType = List.class, column = "id", many = @Many(select = "hello.mapper.PostMapper.getComments"))
    })
    List<Post> getAllPost();

    @Select("SELECT post.id, post.title, post.content, post.created FROM post WHERE post.id = #{id}")
        @Results(value = {
                @Result(id = true, property = "id", column = "id"),
                @Result(property = "title", column = "title"),
                @Result(property = "content", column = "content"),
                @Result(property = "created", column = "created"),
                @Result(property = "comments", javaType = List.class, column = "id", many = @Many(select = "hello.mapper.PostMapper.getComments"))
        })
    Post getPostById(long id);


    @Select("SELECT comment.id, comment.content, comment.created FROM comment WHERE id = #{id}")
    @Results (value = {
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "content", property = "content"),
            @Result(column = "created", property = "created"),
    })
    List<Comment> getComments(long id);

    @Insert("INSERT INTO post (title, content, created) VALUES (#{title}, #{content}, #{created})")
    void savePost(Post post);
}
