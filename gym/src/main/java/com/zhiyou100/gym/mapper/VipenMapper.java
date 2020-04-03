package com.zhiyou100.gym.mapper;

import com.zhiyou100.gym.pojo.Vipen;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface VipenMapper {

    public List<Vipen> findAll0();
    public List<Vipen> findAll1();
    public void add(Vipen vipen);
    public void update(Integer vipenId);

}
