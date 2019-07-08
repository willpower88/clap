package com.willpower.clap.web.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.willpower.clap.entity.Persons;
import com.willpower.clap.service.PersonsService;
import com.willpower.clap.util.ApiResult;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Powersoft on 2019/4/6.
 */
@RestController
@RequestMapping("/persons")
@CrossOrigin
public class PersonsController {

    @Autowired
    private PersonsService personsService;

    @RequestMapping("/person")
    public Persons getPerson() {
        Persons person = personsService.selectByPrimaryKey(1);
        return person;
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ApiOperation(value = "获取用户数据", notes="获取用户数据")
    public ApiResult getAllPersons(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize,true);
        Page<Persons> persons = personsService.findAall();

        return ApiResult.success(persons, persons.getTotal(), pageNum, pageSize);
    }
}
