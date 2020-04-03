package com.zhiyou100.gym.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhiyou100.gym.pojo.Cabinet;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/*
 * 租柜
 *  */

@Mapper
public interface CabinetMapper{

    //查询 所有 租柜

    public List<Cabinet> findWAll();
    public List<Cabinet> findYAll();

    public Cabinet findById(Integer cabId);

    // 1 空闲 2 出租  3故障  0 无效

    public void update1(Integer cabId);
    public void update2(Integer cabNumber);
    public void update3(Integer cabId);
    public void update0(Integer cabId);
}
