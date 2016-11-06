package hello.service;

import java.io.Serializable;

/**
 * Created by W28L30 on 2016/11/5.
 */
public interface SettingService {
    Serializable get(String key);
    Serializable get(String key, Serializable defaultValue);
    void put(String key, Serializable value);
}
