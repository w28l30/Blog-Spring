package Test;

import blog.Application;
import blog.model.Post;
import blog.model.Tag;
import blog.model.support.TagWithCount;
import blog.service.PostService;
import blog.service.TagService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Set;

/**
 * Created by W28L30 on 2016/10/25.
 */
@org.junit.runner.RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class TestTag {
    @Autowired
    private PostService postService;

    private static final Logger log = LoggerFactory.getLogger(TestTag.class);

    @Autowired
    private TagService tagService;

//    @Test
    public void addPostTag() {
        Post post = postService.getById(8);

        Set<Tag> tags = post.getTags();
        Tag tag = tagService.findOrCreateByName("hhh");
        Tag tag1 = tagService.findOrCreateByName("iii");
        Tag tag2 = tagService.findOrCreateByName("jjj");
        log.info("Tag: {}", tag.getName());
        tags.add(tag);
        tags.add(tag1);
        tags.add(tag2);
        postService.insertPostTags(post);
    }

//    @Test
    public void getTags() {
        Post post = postService.getById(8);
        Set<Tag> tags = post.getTags();
        log.info("Tag size: {}", tags.size());
    }

//    @Test
    public void testCountPostByTag() {
        List<TagWithCount> list = postService.countPostsByTags();
        for (TagWithCount t : list) {
            log.info("name: {}, size {}", t.getName(), t.getCount());
        }
    }
}
