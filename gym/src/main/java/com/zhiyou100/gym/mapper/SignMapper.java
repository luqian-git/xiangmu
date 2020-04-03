package com.zhiyou100.gym.mapper;

import com.zhiyou100.gym.pojo.Sign;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SignMapper {

    public List<Sign> findAll0();
    public List<Sign> findAll1();
    public List<Sign> findAll2();
    public Sign findById(Integer singId);
    public void add(Sign sign);
    public void deleteById(Integer singId);
    public void update(Sign sign);

    public Sign findMax();
}
