package com.zhiyou100.gym.service.impl;

import com.zhiyou100.gym.mapper.TrainingMapper;
import com.zhiyou100.gym.mapper.UserMapper;
import com.zhiyou100.gym.pojo.Training;
import com.zhiyou100.gym.service.TrainingService;
import com.zhiyou100.gym.util.NumTimeNowUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sound.sampled.Line;
import java.util.List;

@Service
@Slf4j
public class TrainingServiceImpl implements TrainingService {

    @Autowired
    private TrainingMapper trainingMapper;
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<Training> findAll(Integer t,Integer trainingUserNum) {
        if(t == 0 && trainingUserNum <1){
            return trainingMapper.findAll0();
        }else if (t == 1 && trainingUserNum <1){
            return trainingMapper.findAll1();
        } else if (t == 0 && trainingUserNum > 1){
            return trainingMapper.findByUser0(trainingUserNum);
        }else{
            return trainingMapper.findByUser1(trainingUserNum);
        }
    }

    @Override
    public Training findById(Integer trainingId) {
        return trainingMapper.findById(trainingId);
    }

    @Override
    public String upTime(Integer trainingId) {
        System.out.println("id"+trainingId);
        //获取本次时长
        Training training  = trainingMapper.selectThisTime(trainingId);
        //累计时长
        Training training1 = trainingMapper.findLast(training);
        System.out.println("本次时长"+training);
        System.out.println("累计时长"+training1);
        //设置运动结束时间 状态 <-- 如果先 设置结束 哪累计永远都是 本条数据
        trainingMapper.upTime(trainingId);
        //查询本会员 使用设备的累计时长
        //如果查询出来的 最新的 该会员使用的该设备 累计时长 这条数据 等于 空  用户第一次使用
        if(training1 == null){
            training.setTrainingRecordTime(training.getTrainingThisTime());
        }else {
            //累计时长 +  本次时长
            training.setTrainingRecordTime(training.getTrainingThisTime()+training1.getTrainingRecordTime());
        }
        training.setTrainingId(trainingId);
        //设置累计时长
        log.info("更新本次时长以及累计时长"+training);
        trainingMapper.update(training);
        return "成功";
    }

    @Override
    public String add(Training training) {
        if ( userMapper.findByMember(training.getTrainingUserNum()) == null){
            return "会员编号不存在";
        }if (trainingMapper.oneGo(training.getTrainingUserNum())!= null){
            return "已有训练尚未结束";
        }
        training.setTrainingNumber( NumTimeNowUtil.NowTime());
        trainingMapper.add(training);
        return "成功";
    }

    @Override
    public List<Training> findNow(Integer trainingUserNum) {
        return trainingMapper.findNow(trainingUserNum);
    }

    @Override
    public List<Training> findAllDate(Integer trainingUserNum) {
        return trainingMapper.findAllDate(trainingUserNum);
    }
}
