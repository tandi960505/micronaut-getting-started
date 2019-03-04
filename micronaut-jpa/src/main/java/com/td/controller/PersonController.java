package com.td.controller;

import com.td.domain.Person;
import com.td.service.PersonService;
import io.micronaut.http.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;

import javax.inject.Inject;
import javax.validation.constraints.NotNull;
import java.util.List;

@Slf4j
@Controller("/person")
public class PersonController {
    @Inject
    private PersonService personService;

    @Operation(
            summary = "获取所有的person",
            description = "获取所有的person数据，并返回json格式数据"
    )
    @Get("/all")
    public List<Person> findPersonAll() {
        return personService.selectAll();
    }

    @Operation(
            summary = "根据id获取person",
            description = "根据person id获取单个person，并返回json格式数据"
    )
    @Get("/{id}")
    public Person findPersonById(@NotNull Integer id) {
        return personService.select(id);
    }

    @Operation(
            summary = "根据id更新person",
            description = "根据已存在的person的id修改该person的name, age，修改成功返回该person的id"
    )
    @Post("/{id}/{name}/{age}")
    public Integer updatePerson(@NotNull Integer id, String name, int age) {
        Person person = new Person();
        person.setId(id);
        person.setName(name);
        person.setAge(age);
        personService.update(person);
        log.info("{} - 更新成功", person);
        return person.getId();
    }

    @Operation(
            summary = "根据id删除person",
            description = "根据id删除person，并返回被删除person的id"
    )
    @Delete("/{id}")
    public Integer deletePerson(@NotNull Integer id){
        Person person = new Person();
        person.setId(id);
        personService.delete(person);
        log.info("{} - 删除成功", person);
        return id;
    }

    @Operation(
            summary = "保存person，数据用restful请求传入",
            description = "传入person的name和age来保存person，并返回保存成功的person的id"
    )
    @Put("/save/{name}/{age}")
    public Integer savePerson(String name, int age) {
        Person person = null;
        try {
            person = new Person();
            person.setName(name);
            person.setAge(age);

            //设了自动生成id之后，不要再手动存入id，否者出现以下问题
            //Caused by: org.hibernate.PersistentObjectException: detached entity passed to persist
            personService.save(person);

            log.info("{} - persist success", person);
            return person.getId();
        } catch (Exception e) {
            e.printStackTrace();
        }
        log.info("{} - persist failure！！！", person);
        return person.getId();
    }


    @Operation(
            summary = "保存person，数据用json传入",
            description = "传入person的name和age来保存person，并返回保存成功的person的id"
    )
    @Put("/save")
    public Integer savePerson(@Body Person person) {
        try {
            personService.save(person);

            log.info("{} - persist success", person);
            return person.getId();
        } catch (Exception e) {
            e.printStackTrace();
        }
        log.info("{} - persist failure！！！", person);
        return person.getId();
    }

    @Operation(
            summary = "health check",
            description = "用于测试controller是否可用"
    )
    @Get("/check")
    public String check() {
        return "ok";
    }
}
