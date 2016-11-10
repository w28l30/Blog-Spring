package blog.service;

import blog.mapper.CommentMapper;
import blog.model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by W28L30 on 2016/10/22.
 */
@Service
public class CommentService {

    @Autowired
    private CommentMapper commentMapper;

    public void saveComment(Comment comment) {
        commentMapper.saveComment(comment);
    }
}
