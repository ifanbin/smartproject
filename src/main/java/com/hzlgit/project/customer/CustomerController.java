package com.hzlgit.project.customer;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = {"客户操作"})
public class CustomerController {
    private final static Logger log = LoggerFactory.getLogger(CustomerController.class);

    @RequestMapping(value="api/customer/{customerId}", method = RequestMethod.GET)
    @ApiOperation("获取客户信息")
    public Customer getCustomer(@PathVariable Long customerId){
        log.info("access customer, id is " + customerId );
        Customer customer = new Customer();
        customer.setId(customerId);
        return customer;
    }
}
