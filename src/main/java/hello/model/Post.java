package hello.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

/**
 * Created by W28L30 on 2016/10/12.
 */
@Getter @Setter
public class Post {
    private Long id;

    @Size(min=2, max=30)
    private String title;

    @Size(min=1)
    private String content;

    private Date created;

    private List<Comment> comments;

    public Post() {
        this.created = new Date();
    }

    public Post(String title, String content) {
        this.title = title;
        this.content = content;
        this.created = new Date();
    }

    public Post(Long id, String title, String content, Date created) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.created = created;
    }
}
