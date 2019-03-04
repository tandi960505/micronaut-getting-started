package com.td.service;

import com.td.domain.Person;
import io.micronaut.configuration.hibernate.jpa.scope.CurrentSession;
import io.micronaut.spring.tx.annotation.Transactional;

import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Singleton
public class PersonServiceImpl implements PersonService {

    @PersistenceContext // 将EntityManager持久化到上下文中
    private EntityManager entityManager;
    public PersonServiceImpl(@CurrentSession EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public Integer save(Person person){
        entityManager.persist(person);
        return person.getId();
    }

    @Override
    @Transactional
    public Integer delete(Person person) {
        entityManager.remove(person);
        return person.getId();
    }

    @Override
    @Transactional
    public Integer update(Person person) {
        // entityManager.refresh(person); // 该方法是刷新不是更新
        // 表名首字母大写（默认和实体类一样子哟）
        return entityManager.createQuery("update Person p set p.name = :name, p.age = :age where p.id = :id")
                .setParameter("name", person.getName())
                .setParameter("age", person.getAge())
                .setParameter("id", person.getId())
                .executeUpdate();
    }

    @Override
    @Transactional(readOnly = true)
    public Person select(Integer id) {
        return entityManager.find(Person.class, id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Person> selectAll() {
        List<Person> persons = entityManager
                .createQuery("select p from Person p", Person.class)
                .getResultList();

        return persons;
    }

}
