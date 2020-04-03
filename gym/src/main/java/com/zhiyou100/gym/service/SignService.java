package com.zhiyou100.gym.service;

import com.zhiyou100.gym.pojo.Sign;

import java.util.List;

public interface SignService {
    public List<Sign> findAll(Integer q);
    public Sign findById(Integer singId);
    public String add(Sign sign);
    public String add2(Long phone,String desc);
    public void deleteById(Integer singId);
    public void update(Sign sign);
}
