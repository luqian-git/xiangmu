package com.zhiyou100.gym.service.impl;

import com.zhiyou100.gym.mapper.ScheduleMapper;
import com.zhiyou100.gym.pojo.Schedule;
import com.zhiyou100.gym.service.ScheduleService;
import com.zhiyou100.gym.util.NumTimeNowUtil;
import com.zhiyou100.gym.util.PageNumUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleServiceImpl implements ScheduleService {

    @Autowired
    private ScheduleMapper scheduleMapper;

    @Override
    public List<Schedule> findAll() {
        return scheduleMapper.findAll();
    }

    @Override
    public Schedule findById(Integer scheduleId) {
        return scheduleMapper.findById(scheduleId);
    }

    @Override
    public void deleteById(Integer scheduleId) {
        scheduleMapper.deleteById(scheduleId);
    }

    @Override
    public String add(Schedule schedule) {
        if (scheduleMapper.findHave(schedule.getScheduleCoachNum())!=null){
            return "今日已添加日程";
        }
        schedule.setScheduleNum(NumTimeNowUtil.NowDate());
        scheduleMapper.add(schedule);
        return "成功";
    }

    @Override
    public void update(Schedule schedule) {
        scheduleMapper.update(schedule);
    }

    @Override
    public List<Schedule> findNum(Integer scheduleCoachNum) {
        return scheduleMapper.findNum(scheduleCoachNum);
    }

    public Integer num = PageNumUtil.PageNum;
    @Override
    public Integer findCount() {
        // 获取 数据库 中 数量
        int count = scheduleMapper.findCount();
        int Page = count / num;
        if (count % num != 0) {
            Page++;
        }
        return Page;
    }

    @Override
    public Integer findDCount(Integer scheduleCoachNum) {
        // 获取 数据库 中 数量
        int count = scheduleMapper.findCountD(scheduleCoachNum);
        int Page = count / num;
        if (count % num != 0) {
            Page++;
        }
        return Page;
    }

    @Override
    public List<Schedule> findByPage(Integer page) {
        if (page == null || page < 1) {
            page = 1;
        }
        int size = num;
        //跳过多条数据
        int pages = (page - 1) * size;
        return scheduleMapper.findByPage(pages, size);
    }

    @Override
    public List<Schedule> findDByPage(Integer page, Integer scheduleCoachNum) {
        if (page == null || page < 1) {
            page = 1;
        }
        int size = num;
        //跳过多条数据
        int pages = (page - 1) * size;
        return scheduleMapper.findDByPage(pages, size,scheduleCoachNum);
    }
}
