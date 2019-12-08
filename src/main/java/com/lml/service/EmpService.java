package com.lml.service;

import com.lml.entity.Emp;

import java.util.List;

public interface EmpService {
    Integer queryNum();

    List<Emp> queryByPage(Integer begin, Integer size);

    Emp queryOne(Emp emp);
    void add(Emp emp);

    void delete(Emp emp);

    void update(Emp emp);
}
