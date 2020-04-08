package com.zhiyou100.gym.service.impl;

import com.zhiyou100.gym.mapper.CabInfoMapper;
import com.zhiyou100.gym.mapper.CabinetMapper;
import com.zhiyou100.gym.pojo.CabInfo;
import com.zhiyou100.gym.pojo.User;
import com.zhiyou100.gym.service.CabInfoService;
import com.zhiyou100.gym.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

@Service
public class CabInfoServiceImpl implements CabInfoService {

    @Autowired
    private CabInfoMapper cabInfoMapper;
    @Autowired
    private UserService userService;
    @Autowired
    private CabinetMapper cabinetMapper;

    @Override
    public List<CabInfo> findYAll() {
        return cabInfoMapper.findYAll();
    }

    @Override
    public List<CabInfo> findGAll() {
        return cabInfoMapper.findGAll();
    }

    @Override
    public String add(CabInfo cabInfo) {
        User user = userService.findByMember(cabInfo.getCabInfoMember());
        if (user == null){
            return "无输入的会员编号";
        }
        try {
            Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT+08:00"));
            int y = calendar.get(Calendar.YEAR);
            int m = calendar.get(Calendar.MONTH)+1;
            int d = calendar.get(Calendar.DAY_OF_MONTH);
            int mmm = calendar.get(Calendar.MILLISECOND);
            int mm =  Math.round(mmm/10);
            //System.out.println(y+"--"+m+"--"+d+"--"+mm); 毫秒值为 3位
            Integer z = y*1000000+m*10000+d*100+mm;
            //获取 编号
            cabInfo.setCabInfoNumber(z);
            //获取结束日期
                //获取当前时间
            Timestamp timestamp0  = new Timestamp(System.currentTimeMillis());
            Calendar wl = Calendar.getInstance();
            wl.setTime(timestamp0);
            //因为这个就是  12/ 6 / 3 / 1 月四个 档 单位都是月
            wl.add(Calendar.MONTH, cabInfo.getCabInfoDuration());
            //再把推日期之后的 时间 放进来
            Timestamp time1 = new Timestamp(wl.getTimeInMillis());
            cabInfo.setCabInfoUpdateTime(time1);
            System.out.println("记录表数据更新"+cabInfo);
            cabInfoMapper.add(cabInfo);
            cabinetMapper.update2(cabInfo.getCabInfoNum());
        }catch (Exception e){
            e.printStackTrace();
        }
        return "已记录";
    }

    @Override
    public CabInfo findBycabInfoId(Integer cabInfoId) {

        return cabInfoMapper.findById(cabInfoId);
    }

    @Override
    public void update(CabInfo cabInfo) {
        Calendar wl = Calendar.getInstance();
        wl.setTime(cabInfo.getCabInfoUpdateTime());
        //因为这个就是  12/ 6 / 3 / 1 月四个 档 单位都是月
        wl.add(Calendar.MONTH, cabInfo.getCabInfoDuration());
        //再把推日期之后的 时间 放进来
        Timestamp time1 = new Timestamp(wl.getTimeInMillis());
        cabInfo.setCabInfoUpdateTime(time1);
        cabInfoMapper.update(cabInfo);
    }
}
