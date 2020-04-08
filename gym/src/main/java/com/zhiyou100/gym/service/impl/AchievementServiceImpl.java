package com.zhiyou100.gym.service.impl;

import com.zhiyou100.gym.mapper.AchievementMapper;
import com.zhiyou100.gym.pojo.Achievement;
import com.zhiyou100.gym.service.AchievementService;
import com.zhiyou100.gym.service.TopService;
import com.zhiyou100.gym.util.NumTimeNowUtil;
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
}
