package hello.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Size;

/**
 * Created by W28L30 on 2016/10/24.
 */
@Getter
@Setter
public class Tag {

    @Size(min = 1)
    private String name;

    private int id;

    public Tag() {}

    public Tag(String name) {
        this.name = name;
    }

    public Tag(int id, String name) {
        this.id = id;
        this.name = name;
    }

}
