package hello.repository;

import hello.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by W28L30 on 2016/10/19.
 */
public interface CommentRepository  extends JpaRepository<Comment, Long> {
}
