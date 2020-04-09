package com.zhiyou100.gym.service;


import com.zhiyou100.gym.pojo.Equip;

import java.util.List;

public interface EquipService {

    public List<Equip> findAll();
    public Equip findById(Integer equipId);
    public void add(Equip equip);
    public void deleteById(Integer equipId);
    public void update(Equip equip);

    public Integer findCount();

    public List<Equip> findByPage(Integer page);

}
