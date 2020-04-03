package com.zhiyou100.gym.mapper;

import com.zhiyou100.gym.pojo.Potential;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PotentialMapper {

    public List<Potential> findAll();
    public Potential findById(Integer potId);
    public void add(Potential potential);
    public void deleteById(Integer potId);
    public void update(Potential potential);

    public Potential findMax();
    public Potential findByPhone(Long potPhone);
}
