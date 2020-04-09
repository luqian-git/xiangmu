package com.zhiyou100.gym.service.impl;

import com.zhiyou100.gym.mapper.AchievementMapper;
import com.zhiyou100.gym.pojo.Achievement;
import com.zhiyou100.gym.service.AchievementService;
import com.zhiyou100.gym.service.TopService;
import com.zhiyou100.gym.util.NumTimeNowUtil;
import com.zhiyou100.gym.util.PageNumUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AchievementServiceImpl implements AchievementService {

    @Autowired
    private AchievementMapper achievementMapper;
    @Autowired
    private TopService topService;

    @Override
    public List<Achievement> findAll() {
        return achievementMapper.findAll();
    }

    @Override
    public List<Achievement> findCoachNum(Integer achCoachNum) {
        return achievementMapper.findCoachNum(achCoachNum);
    }

    @Override
    public void add(Achievement achievement) {
        achievement.setAchNum(NumTimeNowUtil.NowTime());
        achievement.setAchDesc(topService.findById(achievement.getAchTopId()).getTopDesc());
        System.out.println(achievement);
        achievementMapper.add(achievement);
    }

    @Override
    public void update1(Integer achId) {
        achievementMapper.update1(achId);
    }

    public Integer num = PageNumUtil.PageNum;
    @Override
    public Integer findCount() {
        // 获取 数据库 中 数量
        int count = achievementMapper.findCount();
        int Page = count / num;
        if (count % num != 0) {
            Page++;
        }
        return Page;
    }

    @Override
    public List<Achievement> findByPage(Integer page) {
        if (page == null || page < 1) {
            page = 1;
        }
        int size = num;
        //跳过多条数据
        int pages = (page - 1) * size;
        return achievementMapper.findByPage(pages, size);
    }

    @Override
    public Integer findCoachNumCount(Integer achCoachNum) {
        // 获取 数据库 中 数量
        int count = achievementMapper.findCoachNumCount(achCoachNum);
        int Page = count / num;
        if (count % num != 0) {
            Page++;
        }
        return Page;
    }

    @Override
    public List<Achievement> findCoachNumByPage(Integer page, Integer achCoachNum) {
        if (page == null || page < 1) {
            page = 1;
        }
        int size = num;
        //跳过多条数据
        int pages = (page - 1) * size;
        return achievementMapper.findCoachNumByPage(pages, size,achCoachNum);
    }
}
