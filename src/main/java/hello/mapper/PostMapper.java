package hello.mapper;

import hello.model.Post;
import hello.model.Tag;
import hello.model.support.TagWithCount;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Set;

/**
 * Created by W28L30 on 2016/10/22.
 */
@Mapper
public interface PostMapper {


//    @Select("SELECT post.id, post.title, post.content, post.created FROM post")
//    @Results(value = {
//            @Result(id = true, property = "id", column = "id"),
//            @Result(property = "title", column = "title"),
//            @Result(property = "content", column = "content"),
//            @Result(property = "created", column = "created"),
//            @Result(property = "comments", javaType = List.class, column = "id", many = @Many(select = "hello.mapper.CommentMapper.getComments"))
//    })
    List<Post> getAllPosts();
//
//    @Select("SELECT post.id, post.title, post.content, post.created FROM post WHERE post.id = #{id}")
//        @Results(value = {
//                @Result(id = true, property = "id", column = "id"),
//                @Result(property = "title", column = "title"),
//                @Result(property = "content", column = "content"),
//                @Result(property = "created", column = "created"),
//                @Result(property = "comments", javaType = List.class, column = "id", many = @Many(select = "hello.mapper.CommentMapper.getComments"))
//        })
    Post getPostById(long id);
//
//    @Insert("INSERT INTO post (title, content, created) VALUES (#{title}, #{content}, #{created})")
//    @Options(useGeneratedKeys = true)
    void savePost(Post post);

    void insertPostTags(Post post);

    List<TagWithCount> countPostsByTags();

    List<Post> getPostsByTag(String tagName);
}
