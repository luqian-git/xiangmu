package com.zhiyou100.gym.service.impl;

import com.zhiyou100.gym.mapper.RechargeMapper;
import com.zhiyou100.gym.pojo.Achievement;
import com.zhiyou100.gym.pojo.Recharge;
import com.zhiyou100.gym.service.AchievementService;
import com.zhiyou100.gym.service.RechargeService;
import com.zhiyou100.gym.service.VipCardService;
import com.zhiyou100.gym.util.NumTimeNowUtil;
import com.zhiyou100.gym.util.PageNumUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RechargeServiceImpl implements RechargeService {

    @Autowired
    private RechargeMapper rechargeMapper;
    @Autowired
    private VipCardService vipCardService;
    @Autowired
    private AchievementService achievementService;

    @Override
    public List<Recharge> findRTC() {
        return rechargeMapper.findRTC();
    }

    @Override
    public List<Recharge> findrechUserMember(Integer rechUserMember) {
        return rechargeMapper.findrechUserMember(rechUserMember);
    }

    @Override
    public Recharge findById(Integer rechId) {
        return rechargeMapper.findById(rechId);
    }

    @Override
    public void deleteById(Integer rechId) {
        rechargeMapper.deleteById(rechId);
    }

    @Override
    public String add(Recharge recharge) {
        recharge.setRechNumber(NumTimeNowUtil.NowTime());
        String row = vipCardService.balanceChange(recharge.getRechUserMember(),recharge.getRechMoney());
        rechargeMapper.add(recharge);
        //私教
            Achievement achievement = new Achievement();

            achievement.setAchCoachNum(recharge.getRechAch());

            achievement.setAchTopId(recharge.getRechTopId());

            if (recharge.getRechMoney() <0){
                Double j = (-recharge.getRechMoney());
                achievement.setAchTopPrice(j);
            }else {
                Double j = (recharge.getRechMoney());
                achievement.setAchTopPrice(j);
            }
            achievement.setAchUserNum(recharge.getRechUserMember());
            achievementService.add(achievement);
        return row;
    }
    public Integer num = PageNumUtil.PageNum;
    @Override
    public Integer findCount() {
        // 获取 数据库 中 数量
        int count = rechargeMapper.findCount();
        int Page = count / num;
        if (count % num != 0) {
            Page++;
        }
        return Page;
    }

    @Override
    public Integer findrechUserMemberCount(Integer rechUserMember) {
        // 获取 数据库 中 数量
        int count = rechargeMapper.findrechUserMemberCount(rechUserMember);
        int Page = count / num;
        if (count % num != 0) {
            Page++;
        }
        return Page;
    }

    @Override
    public List<Recharge> findRTCByPage(Integer page) {
        if (page == null || page < 1) {
            page = 1;
        }
        int size = num;
        //跳过多条数据
        int pages = (page - 1) * size;
        return rechargeMapper.findRTCByPage(pages, size);
    }

    @Override
    public List<Recharge> findrechUserMemberByPage(Integer page ,Integer rechUserMember) {
        if (page == null || page < 1) {
            page = 1;
        }
        int size = num;
        //跳过多条数据
        int pages = (page - 1) * size;
        return rechargeMapper.findrechUserMemberByPage(pages, size,rechUserMember);
    }
}
