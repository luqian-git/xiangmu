package com.zhiyou100.gym.service.impl;

import com.zhiyou100.gym.mapper.CoachMapper;
import com.zhiyou100.gym.mapper.EquipMapper;
import com.zhiyou100.gym.mapper.MaintainMapper;
import com.zhiyou100.gym.pojo.Maintain;
import com.zhiyou100.gym.service.MaintainService;
import com.zhiyou100.gym.util.NumTimeNowUtil;
import com.zhiyou100.gym.util.PageNumUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaintainServiceImpl implements MaintainService {

    @Autowired
    private MaintainMapper maintainMapper;
    @Autowired
    private EquipMapper equipMapper;
    @Autowired
    private CoachMapper coachMapper;

    @Override
    public List<Maintain> findAll() {
        return maintainMapper.findAll();
    }

    @Override
    public Maintain findById(Integer maintainId) {
        return maintainMapper.findById(maintainId);
    }

    @Override
    public String add(Maintain maintain) {
        if (equipMapper.findByNum(maintain.getMaintainEquipNum()) == null){
            return "设备编号错误";
        }else if (coachMapper.findByNum(maintain.getMaintainCoachNumber()) == null){
            return "员工编号错误";
        }
        maintain.setMaintainNum(NumTimeNowUtil.NowTime());
        maintainMapper.add(maintain);
        return "成功";
    }

    @Override
    public String update(Maintain maintain) {
        if (equipMapper.findByNum(maintain.getMaintainEquipNum()) == null){
            return "设备编号错误";
        }else if (coachMapper.findByNum(maintain.getMaintainCoachNumber()) == null){
            return "员工编号错误";
        }
        maintainMapper.update(maintain);
        return "成功";
    }

    @Override
    public void deleteById(Integer maintainId) {
        maintainMapper.deleteById(maintainId);
    }

    public Integer num = PageNumUtil.PageNum;
    @Override
    public Integer findCount() {
        // 获取 数据库 中 数量
        int count = maintainMapper.findCount();
        int Page = count / num;
        if (count % num != 0) {
            Page++;
        }
        return Page;
    }

    @Override
    public List<Maintain> findByPage(Integer page) {
        if (page == null || page < 1) {
            page = 1;
        }
        int size = num;
        //跳过多条数据
        int pages = (page - 1) * size;
        return maintainMapper.findByPage(pages, size);
    }
}
