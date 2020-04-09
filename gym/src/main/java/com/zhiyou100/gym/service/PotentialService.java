package com.zhiyou100.gym.service;

import com.zhiyou100.gym.pojo.Potential;

import java.util.List;

public interface PotentialService {

    public List<Potential> findAll();
    public Potential findById(Integer potId);
    public void add(Potential potential);
    public void deleteById(Integer potId);
    public void update(Potential potential);

    public Integer findCount();

    public List<Potential> findByPage(Integer page);

}
