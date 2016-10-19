package hello.controller;

import hello.exception.PostNotFoundException;
import hello.model.Post;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by W28L30 on 2016/10/12.
 */
public class Data {
    public static byte[] avatar = null;

    public static List<Post> posts = new ArrayList<>();
    static {
        posts.add(new Post("title1", "content1"));
        posts.add(new Post("title2", "content2"));
    }

    public static Post getById(long id) {
        return posts.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .orElseThrow(PostNotFoundException::new);
    }

    public static void add(String title, String content) {
        posts.add(new Post(title, content));
    }

    public static Post add(Post post) {
        Post result = new Post(post.getTitle(), post.getContent());
        posts.add(result);
        return result;
    }
}
