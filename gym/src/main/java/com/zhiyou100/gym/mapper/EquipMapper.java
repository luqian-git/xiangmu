package com.zhiyou100.gym.mapper;

import com.zhiyou100.gym.pojo.Equip;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface EquipMapper {

    public List<Equip> findAll();
    public Equip findById(Integer equipId);
    public void add(Equip equip);
    public void deleteById(Integer equipId);
    public void update(Equip equip);

    public Equip findMax();

    //通过编号查询
    public Equip findByNum(Integer equipNum);

    //分页
    public Integer findCount();
    public List<Equip> findByPage(@Param("start") int start, @Param("size") int size);


}
