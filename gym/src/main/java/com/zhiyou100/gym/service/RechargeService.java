package com.zhiyou100.gym.service;

import com.zhiyou100.gym.pojo.Recharge;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//事务
@Transactional
public interface RechargeService {

    //充值记录
    public List<Recharge> findRTC();

    //根据 会员号 查询记录

    public List<Recharge> findrechUserMember(Integer rechUserMember);

    //
    public Recharge findById(Integer rechId);

    public void deleteById(Integer rechId);

    public String add(Recharge recharge);

    public Integer findCount();
    public Integer findrechUserMemberCount(Integer rechUserMember);
    public List<Recharge> findRTCByPage(Integer page);
    public List<Recharge> findrechUserMemberByPage(Integer page,Integer rechUserMember);


}
