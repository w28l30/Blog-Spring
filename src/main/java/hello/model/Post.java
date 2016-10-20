package hello.model;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

/**
 * Created by W28L30 on 2016/10/12.
 */
@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Size(min=2, max=30)
    private String title;

    @Size(min=1)
    private String content;

    private Date created;

    @OneToMany(mappedBy = "post")
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
