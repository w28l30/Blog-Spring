package hello.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Size;

/**
 * Created by W28L30 on 2016/10/24.
 */
@Getter
@Setter
public class Tag extends BaseModel {

    @Size(min = 1)
    private String name;


    public Tag() {}

    public Tag(String name) {
        this.name = name;
    }

}
