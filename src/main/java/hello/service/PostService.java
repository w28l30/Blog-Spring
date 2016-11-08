package hello.service;

import hello.mapper.PostMapper;
import hello.model.Post;
import hello.model.Tag;
import hello.model.support.TagWithCount;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by W28L30 on 2016/10/22.
 */
@Service
public class PostService {

    @Autowired
    private PostMapper postMapper;

    @Autowired
    private TagService tagService;

    public static final Logger logger = LoggerFactory.getLogger(PostService.class);

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

    public Set<Tag> parseTagNames(String tagNames) {
        Set<Tag> tags = new HashSet<>();
        if (tagNames != null && !tagNames.isEmpty()) {
            tagNames = tagNames.toLowerCase();
            String[] names = tagNames.split("\\s*, \\s*");
            for (String name : names) {
                logger.info("Tag name: {}", name);
                tags.add(tagService.findOrCreateByName(name));
            }
        }
        return tags;
    }

    public String getTagNames(Set<Tag> tags) {
        if (tags == null || tags.isEmpty())
            return "";


        StringBuilder names = new StringBuilder();
        tags.forEach(tag -> names.append(tag.getName()).append(","));
        names.deleteCharAt(names.length() - 1);

        return names.toString();
    }

    public List<TagWithCount> countPostsByTags() {
        return postMapper.countPostsByTags();
    }

    public List<Post> getPostsByTag(String tagName) {
        return postMapper.getPostsByTag(tagName);
    }

    public void deletePost(Long postId) {
        postMapper.deletePostById(postId);
    }

    public void deletePostTags(Long postId) {
        postMapper.deletePostTags(postId);
    }

    public void update(Post post) {
        postMapper.updatePost(post);
    }
}
