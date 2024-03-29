package com.hzlgit.project.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PersonService {
    @Autowired
    private PersonDao personDao;

    public Person findByName(String name){
        return this.personDao.findByName(name);
    }

}
