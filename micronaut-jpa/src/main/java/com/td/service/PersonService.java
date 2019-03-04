package com.td.service;

import com.td.domain.Person;

import java.util.List;

public interface PersonService {

    /**
     * @param person
     * @return id
     */
    Integer save(Person person);

    /**
     * @param person
     * @return id
     */
    Integer delete(Person person);

    /**
     * @param person
     * @return id
     */
    Integer update(Person person);

    Person select(Integer id);
    List<Person> selectAll();

}
