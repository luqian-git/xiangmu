package com.zhiyou100.gym.mapper;

import com.zhiyou100.gym.pojo.CabInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/*
*租柜记录
* */

@Mapper
public interface CabInfoMapper{

    // 已 出租记录 and 已过期出租记录

    public List<CabInfo> findYAll();
    public List<CabInfo> findGAll();

    public Integer findCount(Integer cabInfoStatus);

    public List<CabInfo> findByPage(@Param("start") int start, @Param("size") int size,Integer cabInfoStatus);

    public CabInfo findById(Integer cabInfoId);

    public void add(CabInfo cabInfo);
    //过期
    public void deleteById(Integer cabInfoId);

    //续费
    public void update(CabInfo cabInfo);
    //失效记录
    public List<CabInfo> expired();
}
