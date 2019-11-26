package com.hzlgit.project;

import cn.hutool.core.exceptions.StatefulException;
import com.hzlgit.project.config.MyConfig;
import com.hzlgit.project.customer.Customer;
import lombok.Value;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
/*不受权限控制，生产环境删除*/
public class HomeController {
    private final static Logger log = LoggerFactory.getLogger(HomeController.class);

    @Autowired
    private MyConfig myConfig;

    public MyConfig getMyConfig() {
        return myConfig;
    }

    public void setMyConfig(MyConfig myConfig){
        this.myConfig = myConfig;
    }

    @RequestMapping("/")
    public String home(){
        log.info("access home! \noutput: hello world!");
        log.info("当前环境："+this.myConfig.getNwflag());
        return "hello world"+this.myConfig.getNwflag();
    }

    @RequestMapping("/testException/{id}")
    public Long getCustomer(@PathVariable Long id){
        log.info("异常测试 id == " + id );
        if(-1 == id)
            throw new StatefulException(HttpStatus.BAD_REQUEST.value(), "后台有异常！");
        else
            return id;
    }
}
