package com.zhiyou100.gym.service.impl;

import com.zhiyou100.gym.mapper.UserMapper;
import com.zhiyou100.gym.mapper.VipCardMapper;
import com.zhiyou100.gym.pojo.User;
import com.zhiyou100.gym.pojo.VipCard;
import com.zhiyou100.gym.service.VipCardService;
import com.zhiyou100.gym.util.PageNumUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class VipCardServiceImpl implements VipCardService {

    @Autowired
    private VipCardMapper vipCardMapper;
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<VipCard> findAll() {
        return vipCardMapper.findAll();
    }

    @Override
    public void add(VipCard vipCard) {

        User userMax = userMapper.findByHMax();
        // 添加账号
        User user = new User();
        user.setUsAccount(vipCard.getUsAccount());
        user.setUsPassword(vipCard.getUsPassword());
        user.setUsName(vipCard.getUsName());
        user.setUsSex(vipCard.getUsSex());
        user.setUsAge(vipCard.getUsAge());
        //默认头像
        user.setUsHead("/img/2.jpg");
        user.setUsLabel("会员有点懒,什么也没写");
        user.setUsIntroduce("会员有点懒,什么也没写");
        user.setUsMember(userMax.getUsMember()+1);
        userMapper.add(user);
        //通过刚创建的账号查询 这条数据
        User us = userMapper.findAccount(vipCard.getUsAccount());
        userMapper.addRole(us.getUsId(),vipCard.getUsRole());
        //账号 id
        vipCard.setCardUserId(us.getUsId());
        // 添加员工-- 获得会员编号
        vipCard.setCardNumber(userMax.getUsMember()+1);
        vipCardMapper.add(vipCard);
    }

    //余额变动

    @Override
    public String balanceChange(Integer cardNumber,Double change) {
        VipCard vipCard = vipCardMapper.findByNum(cardNumber);
        if(vipCard == null){
            return "无该会员";
        }
        Double balance = vipCard.getCardBalance();
        //如果小于0为 扣款 else 否则 为充值

        if ((balance+change) < 0){
                return "余额不足";
        }else {
            Double result = (balance+change);
            System.out.println("变动后的余额"+result);
            vipCard.setCardBalance(result);
        }
        vipCardMapper.updateBalance(vipCard);
        return "余额变动"+vipCard.getCardBalance();
    }

    //注销

    @Override
    public void update(Integer cardNumber) {
        userMapper.cancellation(cardNumber);
        vipCardMapper.update(cardNumber);
    }
    //展示数据
    public Integer num = PageNumUtil.PageNum;

    @Override
    public Integer findCount() {
        // 获取 数据库 中 数量
        int count = vipCardMapper.findCount();
        int Page = count / num;
        if (count % num != 0) {
            Page++;
        }
        return Page;
    }
    @Override
    public List<VipCard> findByPage(Integer page){
        if (page == null || page < 1) {
            page = 1;
        }
        int size = num;
        //跳过多条数据
        int pages = (page - 1) * size;
        return vipCardMapper.findByPage(pages, size);
    }
}
