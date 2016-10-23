package hello.service;

import hello.mapper.PostMapper;
import hello.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by W28L30 on 2016/10/22.
 */
@Service
public class PostService {

    @Autowired
    private PostMapper postMapper;

    public List<Post> getAll() {
        return postMapper.getAllPost();
    }

    public void save(Post post) {
        postMapper.savePost(post);
    }

    public Post getById(long id) {
        return postMapper.getPostById(id);
    }
}
