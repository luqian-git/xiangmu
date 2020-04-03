package com.zhiyou100.gym.service;

import com.zhiyou100.gym.pojo.CabInfo;

import java.util.List;

public interface CabInfoService {

    //已出租
    public List<CabInfo> findYAll();
    //未出租
    public List<CabInfo> findGAll();

    //出租
    public String add(CabInfo cabInfo);
    //续费
    public void update(CabInfo cabInfo);
}
