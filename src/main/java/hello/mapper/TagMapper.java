package hello.mapper;

import hello.model.Comment;
import hello.model.Tag;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by W28L30 on 2016/10/22.
 */
@Mapper
public interface TagMapper {

    void saveTag(Tag tag);

    Tag findTagByName(String name);

}
