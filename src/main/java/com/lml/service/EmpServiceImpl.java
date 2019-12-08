package com.lml.service;

import com.lml.dao.EmpDao;
import com.lml.entity.Emp;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmpDao empDao;

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public Integer queryNum() {
        return empDao.selectCount(new Emp());
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<Emp> queryByPage(Integer begin, Integer size) {
        return empDao.selectByRowBounds(new Emp(), new RowBounds(begin, size));
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public Emp queryOne(Emp emp) {
        return empDao.selectOne(emp);
    }

    @Override
    public void add(Emp emp) {
        empDao.insert(emp);
    }

    @Override
    public void delete(Emp emp) {
        empDao.delete(emp);
    }

    @Override
    public void update(Emp emp) {
        empDao.updateByPrimaryKeySelective(emp);
    }
}
