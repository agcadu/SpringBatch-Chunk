package com.batch.service;

import com.batch.entities.Person;
import com.batch.persistence.IPersonDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements IPersonService{

    @Autowired
    private IPersonDao personDao;

    @Override
    public Iterable<Person> saveAll(List<Person> personList) {
        return personDao.saveAll(personList);

    }
}
