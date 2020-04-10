package com.zhiyou100.gym.service.impl;

import com.zhiyou100.gym.mapper.CabInfoMapper;
import com.zhiyou100.gym.mapper.CabinetMapper;
import com.zhiyou100.gym.pojo.CabInfo;
import com.zhiyou100.gym.pojo.User;
import com.zhiyou100.gym.service.CabInfoService;
import com.zhiyou100.gym.service.UserService;
import com.zhiyou100.gym.util.PageNumUtil;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

@Log4j2
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

    public Integer num = PageNumUtil.PageNum;

    @Override
    public Integer findCount(Integer cabInfoStatus) {
        // 获取 数据库 中 数量
        int count = cabInfoMapper.findCount(cabInfoStatus);
        int Page = count / num;
        if (count % num != 0) {
            Page++;
        }
        return Page;
    }

    @Override
    public List<CabInfo> findByPage(Integer page, Integer cabInfoStatus) {
        if (page == null || page < 1) {
            page = 1;
        }
        int size = num;
        //跳过多条数据
        int pages = (page - 1) * size;
        return cabInfoMapper.findByPage(pages, size,cabInfoStatus);
    }

    @Override
    public void expired() {
       List<CabInfo> cabInfos = cabInfoMapper.expired();
       if (cabInfos.isEmpty()||cabInfos == null){
            log.info("今天并无租柜到期");
       }else {
           for (CabInfo cabInfo:cabInfos){
               cabInfoMapper.deleteById(cabInfo.getCabInfoId());
               cabinetMapper.updateNum(cabInfo.getCabInfoNum());
               log.info("过期柜子编号"+cabInfo.getCabInfoNum()+"租柜记录编号"+cabInfo.getCabInfoNumber()+"租柜会员编号"+ cabInfo.getCabInfoMember());
           }
       }
    }
}
