package com.zhiyou100.gym.service.impl;

import com.zhiyou100.gym.mapper.PotentialMapper;
import com.zhiyou100.gym.mapper.SignMapper;
import com.zhiyou100.gym.mapper.VipenMapper;
import com.zhiyou100.gym.pojo.Sign;
import com.zhiyou100.gym.pojo.User;
import com.zhiyou100.gym.pojo.Vipen;
import com.zhiyou100.gym.service.SignService;
import com.zhiyou100.gym.service.UserService;
import com.zhiyou100.gym.service.VipenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;
@Service
public class SignServiceImpl implements SignService {

    @Autowired
    private SignMapper signMapper;
    @Autowired
    private UserService userService;
    @Autowired
    private VipenService vipenService;
    @Autowired
    private PotentialMapper potentialMapper;


    @Override
    public List<Sign> findAll(Integer q) {
        if (q == 0){
            return signMapper.findAll0();
        }else if (q == 1){
            return signMapper.findAll1();
        }
        return signMapper.findAll2();
    }

    @Override
    public List<Sign> findById(Integer signUserNumber) {
        return signMapper.findByUserNumber(signUserNumber);
    }

    @Override
    public String add(Sign sign) {
        //判断是否今天签到过
        if (signMapper.findByNum(sign.getSignUserNumber())!=null){
            return "今已签到";
        }
        //获取该 员工号 或者  会员号 的账号信息 0 为员工 1  为会员
        Integer member = sign.getSignUserNumber();
        if (member < 10000 && member < 0){
            //获取状态
            sign.setSignStatus(0);
        }else if (member > 10000){
            //获取状态
            sign.setSignStatus(1);
        }
        User user = userService.findByMember(member);
        if (user == null){
            return "员工号/会员号填写错误";
        }
        //获取最大 编号
        sign.setSignNumder(signMapper.findMax().getSignNumder()+1);
        signMapper.add(sign);
        //会员进场 模块
        vipenService.add(user.getUsId());
        return "签到成功";
    }

    @Override
    public String add2(Long phone, String desc) {
        Sign sign = new Sign();
        if (potentialMapper.findByPhone(phone).getPotId() != null){
            sign.setSignDesc(desc);
            sign.setSignNumder(potentialMapper.findByPhone(phone).getPotNumber());
            sign.setSignStatus(2);
            sign.setSignNumder(signMapper.findMax().getSignNumder()+1);
            signMapper.add(sign);
            return "签到成功";
        }
        return "您尚未登记";
    }

    @Override
    public void deleteById(Integer signId) {
        signMapper.deleteById(signId);
    }

    @Override
    public void update(Sign sign) {
        signMapper.update(sign);
    }


}
