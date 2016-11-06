package hello.model;

import lombok.Data;

/**
 * Created by W28L30 on 2016/11/5.
 */
@Data
public class Setting extends BaseModel{
    private String key;

    private String value;
}
