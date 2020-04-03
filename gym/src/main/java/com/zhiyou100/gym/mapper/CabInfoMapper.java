package com.zhiyou100.gym.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhiyou100.gym.pojo.CabInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/*
*租柜记录
* */

@Mapper
public interface CabInfoMapper{

    // 已 出租记录 and 已过期出租记录

    public List<CabInfo> findYAll();
    public List<CabInfo> findGAll();

    public CabInfo findById(Integer cabInfoId);

    public void add(CabInfo cabInfo);
    //过期
    public void deleteById(Integer cabInfoId);

    //续费
    public void update(CabInfo cabInfo);
}
