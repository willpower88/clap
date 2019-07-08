package com.willpower.clap.service;

import com.github.pagehelper.Page;
import com.willpower.clap.entity.Persons;

import java.util.List;

/**
 * Created by Powersoft on 2019/4/6.
 */
public interface PersonsService {

    public Persons selectByPrimaryKey(Integer id);

    public Page<Persons> findAall();
}
