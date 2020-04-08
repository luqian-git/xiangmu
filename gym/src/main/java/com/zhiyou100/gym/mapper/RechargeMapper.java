package com.zhiyou100.gym.mapper;

import com.zhiyou100.gym.pojo.Recharge;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RechargeMapper {

    //查询 所有的 充值记录Recharge 消费类型Top  会员卡vipCard

    public List<Recharge> findRTC();

    //根据 会员编号查询所有关于 该 会员的 余额变动记录

    public List<Recharge> findrechUserMember(Integer rechUserMember);

    public Recharge findById(Integer rechId);

    public void deleteById(Integer rechId);

    public void add(Recharge recharge);

   // public void update(Recharge recharge);
}
