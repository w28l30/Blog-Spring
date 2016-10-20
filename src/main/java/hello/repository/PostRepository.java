package hello.repository;

import hello.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by W28L30 on 2016/10/19.
 */
public interface PostRepository extends JpaRepository<Post, Long> {
}
