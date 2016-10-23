package hello.model;
import lombok.Data;
import lombok.Getter;

import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Data
public class Comment {

    private Long id;

    @Size(min = 1)
    private String content;

    private Date created = new Date();

    private Post post;

}