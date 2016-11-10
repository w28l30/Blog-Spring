package blog.service;

import blog.mapper.TagMapper;
import blog.model.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by W28L30 on 2016/10/25.
 */
@Service
public class TagService {
    @Autowired
    private TagMapper tagMapper;


    public Tag findOrCreateByName(String name) {
        Tag tag = tagMapper.findTagByName(name);
        if (tag == null) {
            tag = new Tag(name);
            tagMapper.saveTag(tag);
        }
        return tag;
    }

    public List<Tag> getAllTags() {
        return tagMapper.getAllTags();
    }
}
