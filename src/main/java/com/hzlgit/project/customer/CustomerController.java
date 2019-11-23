package com.hzlgit.project.customer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    private final static Logger log = LoggerFactory.getLogger(CustomerController.class);

    @RequestMapping(value="/{customerId}", method = RequestMethod.GET)
    public Customer getCustomer(@PathVariable Long customerId){
        log.info("access customer, id is " + customerId );
        Customer customer = new Customer();
        customer.setId(customerId);
        return customer;
    }
}
