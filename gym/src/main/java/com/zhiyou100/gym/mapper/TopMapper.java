package com.zhiyou100.gym.mapper;

import com.zhiyou100.gym.pojo.Top;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TopMapper {

    public List<Top> findAll();
    public Top findById(Integer topId);
    public void add(Top top);
    public void deleteById(Integer topId);
    public void update(Top top);

}
