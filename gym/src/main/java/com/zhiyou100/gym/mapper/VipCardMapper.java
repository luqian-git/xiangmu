package com.zhiyou100.gym.mapper;

import com.zhiyou100.gym.pojo.VipCard;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface VipCardMapper {

   public List<VipCard> findAll();

   //开通会员 并给与 账号

   public void add(VipCard vipCard);
   //注销

   public void update(Integer cardNumber);
    //余额查询

   public VipCard findByNum(Integer cardNumber);
   //余额变动

   public void updateBalance(VipCard vipCard);

}
