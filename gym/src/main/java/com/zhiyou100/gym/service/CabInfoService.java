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

    //单挑查询
    public CabInfo findBycabInfoId(Integer cabInfoId);

    //续费
    public void update(CabInfo cabInfo);

    public Integer findCount(Integer cabInfoStatus);

    public List<CabInfo> findByPage(Integer page,Integer cabInfoStatus);

    public void  expired();

}
