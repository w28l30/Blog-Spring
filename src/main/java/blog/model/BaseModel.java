package blog.model;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang.builder.HashCodeBuilder;

import java.util.Date;

/**
 * Created by W28L30 on 2016/10/26.
 */
@Getter
@Setter
public abstract class BaseModel implements Comparable<BaseModel> {
    private Long id;
    private Date createdAt;
    private Date updatedAt;

    public void prePersist() {
        createdAt = new Date();
        updatedAt = new Date();
    }

    public void preUpdata() {
        updatedAt = new Date();
    }

    @Override
    public int compareTo(BaseModel o) {
        return this.getId().compareTo(o.getId());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BaseModel baseModel = (BaseModel) o;

        return id != null ? id.equals(baseModel.id) : baseModel.id == null;

    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(getId()).toHashCode();
    }


}
