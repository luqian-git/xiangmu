package com.zhiyou100.gym.service.impl;

import com.zhiyou100.gym.mapper.EquipMapper;
import com.zhiyou100.gym.pojo.Equip;
import com.zhiyou100.gym.service.EquipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipServiceImpl implements EquipService {

    @Autowired
    private EquipMapper equipMapper;

    @Override
    public List<Equip> findAll() {
        return equipMapper.findAll();
    }

    @Override
    public Equip findById(Integer equipId) {
        return equipMapper.findById(equipId);
    }

    @Override
    public void add(Equip equip) {
        Equip equip1 = equipMapper.findMax();
        if (equip1 == null){
            equip.setEquipNum(20001);
        }else {
            equip.setEquipNum(equip1.getEquipNum()+1);
        }
        equipMapper.add(equip);
    }

    @Override
    public void deleteById(Integer equipId) {
        equipMapper.deleteById(equipId);
    }

    @Override
    public void update(Equip equip) {
        equipMapper.update(equip);
    }
}
