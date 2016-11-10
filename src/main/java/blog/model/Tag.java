package blog.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Size;
import java.util.Date;

/**
 * Created by W28L30 on 2016/10/24.
 */
@Getter
@Setter
public class Tag extends BaseModel {

    @Size(min = 1)
    private String name;

    private Date created;

    public Tag() {this.created = new Date();}

    public Tag(String name) {
        this.name = name;
        this.created = new Date();
    }

}
