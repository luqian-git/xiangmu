package com.zhiyou100.gym.service;

import com.zhiyou100.gym.pojo.Maintain;

import java.util.List;

public interface MaintainService {

    public List<Maintain> findAll();
    public Maintain findById(Integer maintainId);
    public String add(Maintain maintain);
    public String update(Maintain maintain);
    public void deleteById(Integer maintainId);

    public Integer findCount();

    public List<Maintain> findByPage(Integer page);
}
