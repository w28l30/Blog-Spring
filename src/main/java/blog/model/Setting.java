package blog.model;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by W28L30 on 2016/11/5.
 */
@Data
public class Setting extends BaseModel{
    private String key;

    private Serializable value;
}
