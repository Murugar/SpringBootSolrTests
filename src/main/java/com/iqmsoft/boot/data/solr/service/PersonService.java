package com.iqmsoft.boot.data.solr.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.iqmsoft.boot.data.solr.domain.Person;
import com.iqmsoft.boot.data.solr.domain.PersonRepository;


@Service
public class PersonService {

    @Autowired
    PersonRepository repository;

    public Person findByName(String name) {

        Assert.hasText(name, "can't find a person without a name!");

        return repository.findOneByName(name)
                .orElse(null);
    }
}
