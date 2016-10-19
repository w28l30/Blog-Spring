package hello.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * Created by W28L30 on 2016/10/19.
 */
public class Comment {
    private Long id;

    @Size(min = 1)
    private String content;

    private Date created;

    @NotNull
    private Long post;

    public Comment() {
        this.created = new Date();
    }

    public Comment(Long id, String content, Date created, Long post) {
        this.id = id;
        this.content = content;
        this.created = created;
        this.post = post;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Long getPost() {
        return post;
    }

    public void setPost(Long post) {
        this.post = post;
    }
}
