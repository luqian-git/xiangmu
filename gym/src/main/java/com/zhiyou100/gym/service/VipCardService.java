package com.zhiyou100.gym.service;

import com.zhiyou100.gym.pojo.VipCard;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface VipCardService {

    public List<VipCard> findAll();
    //开通会员

    public void add(VipCard vipCard);
    //注销

    public void update(Integer cardNumber);
    //余额变动

    public String balanceChange(Integer cardNumber,Double change);

}
