package com.zhiyou100.gym.mapper;

import com.zhiyou100.gym.pojo.Training;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TrainingMapper {

    public List<Training> findAll0();
    public List<Training> findAll1();


    //分页
    public Integer findCount0();
    public Integer findCount1();

    public List<Training> findByPage(@Param("start") int start, @Param("size") int size,Integer trainingState,Integer trainingUserNum);
    public List<Training> findByPageAll(@Param("start") int start, @Param("size") int size,Integer trainingState);

    public List<Training> findByUser0(Integer trainingUserNum);
    public List<Training> findByUser1(Integer trainingUserNum);

    public Training findById(Integer trainingId);

    public void add(Training training);


    // 同一时间只有一个 训练 进行

    public Training oneGo(Integer trainingUserNum);


    //结束时间
    public void upTime(Integer trainingId);

    //获取此次时长

    public Training selectThisTime(Integer trainingId);

    //获取最后一次该用户使用 该设备的 累计时间

    public Training findLast(Training training);

    //更新本次累计时长

    public void update(Training training);

    //获取今天的运动 报表

    public List<Training> findNow(Integer trainingUserNum);

    //获取累计的 运动报表

    public List<Training> findAllDate(Integer trainingUserNum);
}
