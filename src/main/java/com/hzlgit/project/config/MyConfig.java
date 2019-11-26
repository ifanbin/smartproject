package com.hzlgit.project.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix="myconfig")
@Component
public class MyConfig {
    private String nwflag;

    public String getNwflag() {
        return nwflag;
    }

    public void setNwflag(String nwflag){
        this.nwflag = nwflag;
    }
}
