package hello.service;

import hello.mapper.PostMapper;
import hello.model.Post;
import hello.model.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by W28L30 on 2016/10/22.
 */
@Service
public class PostService {

    @Autowired
    private PostMapper postMapper;

    @Autowired
    private TagService tagService;

    public List<Post> getAll() {
        return postMapper.getAllPosts();
    }

    public void save(Post post) {
        postMapper.savePost(post);
    }

    public Post getById(long id) {
        return postMapper.getPostById(id);
    }

    public void insertPostTags(Post post) {
        postMapper.insertPostTags(post);
    }

    public List<Tag> parseTagNames(String tagNames) {
        List<Tag> tags = new ArrayList<Tag>();
        if (tagNames != null && !tagNames.isEmpty()) {
            tagNames = tagNames.toLowerCase();
            String[] names = tagNames.split("\\s*, \\s*");
            for (String name : names) {
                tags.add(tagService.findOrCreateByName(name));
            }
        }
        return tags;
    }
}
