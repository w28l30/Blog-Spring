package blog.model.support;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

/**
 * Created by zouyi on 11/8/2016.
 */
@Data
public class SettingForm {
    @NotEmpty
    @NotNull
    private String siteName;

    @NotNull
    private String siteSlogan;

    @NotNull
    private Integer pageSize;

    @NotNull
    private String aboutMe;
}
