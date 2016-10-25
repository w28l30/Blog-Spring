package hello.model;

import lombok.Data;

import javax.validation.constraints.Size;

/**
 * Created by W28L30 on 2016/10/24.
 */
@Data
public class Tag {

    @Size(min = 1)
    private String name;

}
