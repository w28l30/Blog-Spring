package blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by W28L30 on 2016/11/5.
 */
@Service
public class AppSetting {
    @Autowired
    private SettingService settingService;

    private String siteName = "SpringBlog";
    private String siteSlogan = "An interesting place to discover";
    private Integer pageSize = 5;
    private String aboutMe = "My name is w28l30";

    public static final String SITE_NAME = "site_name";
    public static final String SITE_SLOGAN = "site_slogan";
    public static final String PAGE_SIZE = "page_size";
    public static final String ABOUT_ME = "about_me";

    public String getSiteName(){
        return (String) settingService.get(SITE_NAME, siteName);
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
        settingService.put(SITE_NAME, siteName);
    }

    public Integer getPageSize() {
        return (Integer) settingService.get(PAGE_SIZE, pageSize);
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
        settingService.put(PAGE_SIZE, pageSize);
    }

    public String getSiteSlogan() {
        return (String) settingService.get(SITE_SLOGAN, siteSlogan);
    }

    public void setSiteSlogan(String siteSlogan) {
        this.siteSlogan = siteSlogan;
        settingService.put(SITE_SLOGAN, siteSlogan);
    }

    public String getAboutMe() {return (String) settingService.get(ABOUT_ME, aboutMe);}

    public void setAboutMe(String aboutMe) {
        this.aboutMe = aboutMe;
        settingService.put(ABOUT_ME, aboutMe);
    }
}
