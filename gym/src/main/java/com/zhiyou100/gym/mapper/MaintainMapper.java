package com.zhiyou100.gym.mapper;

import com.zhiyou100.gym.pojo.Maintain;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MaintainMapper {

    public List<Maintain> findAll();
    public Maintain findById(Integer maintainId);
    public void add(Maintain maintain);
    public void update(Maintain maintain);
    public void deleteById(Integer maintainId);


    public Integer findCount();
    public List<Maintain> findByPage(@Param("start") int start, @Param("size") int size);



}
