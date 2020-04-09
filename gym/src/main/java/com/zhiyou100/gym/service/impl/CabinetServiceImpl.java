package com.zhiyou100.gym.service.impl;

import com.zhiyou100.gym.mapper.CabinetMapper;
import com.zhiyou100.gym.pojo.Cabinet;
import com.zhiyou100.gym.service.CabinetService;
import com.zhiyou100.gym.util.PageNumUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CabinetServiceImpl implements CabinetService {

    @Autowired
    private CabinetMapper cabinetMapper;

    @Override
    public List<Cabinet> findYAll() {
        return cabinetMapper.findYAll();
    }
    @Override
    public List<Cabinet> findWAll() {
        return cabinetMapper.findWAll();
    }

    @Override
    public Cabinet findById(Integer usId) {
        return null;
    }

    @Override
    public String add(Cabinet user) {
        return null;
    }

    @Override
    public String deleteById(Integer usId) {
        return null;
    }

    @Override
    public String update(Cabinet user) {
        return null;
    }


    @Override
    public void update1(Integer cabId) {
        cabinetMapper.update1(cabId);
    }

    @Override
    public void update3(Integer cabId) {
        cabinetMapper.update3(cabId);
    }

    @Override
    public void insertCab(Cabinet cabinet) {
        cabinetMapper.insert(cabinet);
    }

    public Integer num = PageNumUtil.PageNum;
    @Override
    public Integer findCount13() {
        // 获取 数据库 中 数量
        int count = cabinetMapper.findCount13();
        int Page = count / num;
        if (count % num != 0) {
            Page++;
        }
        return Page;
    }

    @Override
    public List<Cabinet> findByPage13(Integer page) {
        if (page == null || page < 1) {
            page = 1;
        }
        int size = num;
        //跳过多条数据
        int pages = (page - 1) * size;
        return cabinetMapper.findByPage13(pages, size);
    }

    @Override
    public Integer findCount2() {
        // 获取 数据库 中 数量
        int count = cabinetMapper.findCount2();
        int Page = count / num;
        if (count % num != 0) {
            Page++;
        }
        return Page;
    }

    @Override
    public List<Cabinet> findByPage2(Integer page) {
        if (page == null || page < 1) {
            page = 1;
        }
        int size = num;
        //跳过多条数据
        int pages = (page - 1) * size;
        return cabinetMapper.findByPage2(pages, size);
    }
}
