package com.zhiyou100.gym.service.impl;

import com.zhiyou100.gym.mapper.EquipMapper;
import com.zhiyou100.gym.pojo.Equip;
import com.zhiyou100.gym.service.EquipService;
import com.zhiyou100.gym.util.PageNumUtil;
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
    public Integer num = PageNumUtil.PageNum;
    @Override
    public Integer findCount() {
        // 获取 数据库 中 数量
        int count = equipMapper.findCount();
        int Page = count / num;
        if (count % num != 0) {
            Page++;
        }
        return Page;
    }

    @Override
    public List<Equip> findByPage(Integer page) {
        if (page == null || page < 1) {
            page = 1;
        }
        int size = num;
        //跳过多条数据
        int pages = (page - 1) * size;
        return equipMapper.findByPage(pages, size);
    }
}
