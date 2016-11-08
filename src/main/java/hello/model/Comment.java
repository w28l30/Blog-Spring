package hello.model;
import lombok.Data;

import java.util.Date;

import javax.validation.constraints.Size;

@Data
public class Comment extends BaseModel {

    private Long id;

    @Size(min = 1)
    private String content;

    private Date created = new Date();

    private Post post;

}