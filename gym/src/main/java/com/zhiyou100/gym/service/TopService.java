package com.zhiyou100.gym.service;

import com.zhiyou100.gym.pojo.Top;

import java.util.List;

public interface TopService {

    public List<Top> findAll();
    public Top findById(Integer topId);
    public void add(Top top);
    public void deleteById(Integer topId);
    public void update(Top top);
}
