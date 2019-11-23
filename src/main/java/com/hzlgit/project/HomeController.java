package com.hzlgit.project;

import cn.hutool.core.exceptions.StatefulException;
import com.hzlgit.project.customer.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    private final static Logger log = LoggerFactory.getLogger(HomeController.class);

    @RequestMapping("/")
    public String home(){
        log.info("access home! \noutput: hello world!");
        return "hello world";
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
