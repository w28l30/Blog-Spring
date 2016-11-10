package blog.mapper;

import blog.model.Post;
import blog.model.support.TagWithCount;
import org.apache.ibatis.annotations.*;

import java.util.List;

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
//            @Result(property = "comments", javaType = List.class, column = "id", many = @Many(select = "blog.mapper.CommentMapper.getComments"))
//    })
    List<Post> getAllPosts();
//
//    @Select("SELECT post.id, post.title, post.content, post.created FROM post WHERE post.id = #{id}")
//        @Results(value = {
//                @Result(id = true, property = "id", column = "id"),
//                @Result(property = "title", column = "title"),
//                @Result(property = "content", column = "content"),
//                @Result(property = "created", column = "created"),
//                @Result(property = "comments", javaType = List.class, column = "id", many = @Many(select = "blog.mapper.CommentMapper.getComments"))
//        })
    Post getPostById(long id);
//
//    @Insert("INSERT INTO post (title, content, created) VALUES (#{title}, #{content}, #{created})")
//    @Options(useGeneratedKeys = true)
    void savePost(Post post);

    void insertPostTags(Post post);

    List<TagWithCount> countPostsByTags();

    List<Post> getPostsByTag(String tagName);

    @Delete("DELETE FROM post WHERE id = #{postId}")
    void deletePostById(Long postId);

    @Update("UPDATE post SET content = #{content}, title = #{title} WHERE id = #{id}")
    void updatePost(Post post);

    @Delete("DELETE FROM post_tag WHERE post_id = #{postId}")
    void deletePostTags(Long postId);
}
