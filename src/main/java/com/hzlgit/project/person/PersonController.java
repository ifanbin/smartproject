package com.hzlgit.project.person;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = {"人员操作"})
public class PersonController {
    @Autowired
    private PersonService personService;

    @RequestMapping(value="api/person", method = RequestMethod.GET)
    @ApiOperation("通过姓名查询，获取相关人员信息")
    public Person findByName(String name){
        Person person = this.personService.findByName(name);
        return person;
    }

}
