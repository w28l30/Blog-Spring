package hello.mapper;

import hello.model.Setting;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * Created by zouyi on 11/8/2016.
 */
@Mapper
public interface SettingMapper {
    @Select("SELECT _key, _value FROM setting WHERE _key = #{key}")
    public Setting findByKey(String key);

    @Insert("INSERT INTO setting(_key, _value) VALUES (#{key}, #{value)")
    public void save(Setting setting);
}
