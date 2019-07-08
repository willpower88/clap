package com.willpower.clap.service.impl;

import com.github.pagehelper.Page;
import com.willpower.clap.entity.Persons;
import com.willpower.clap.mapper.PersonsMapper;
import com.willpower.clap.service.PersonsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Powersoft on 2019/4/6.
 */
@Service
public class PersonsServiceImpl implements PersonsService {

    @Autowired
    PersonsMapper personsMapper;

    @Override
    public Persons selectByPrimaryKey(Integer id) {
        return personsMapper.selectByPrimaryKey(id);
    }

    @Override
    public Page<Persons> findAall() {
        return personsMapper.findAll();
    }
}
