package com.zhiyou100.gym.mapper;

import com.zhiyou100.gym.pojo.Sign;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

@Mapper
public interface SignMapper {
    public List<Sign> findAll0();
    public List<Sign> findAll1();
    public List<Sign> findAll2();

    //分页
    public Sign findNum(Integer signUserNumber);

    public Integer findCount(Integer signStatus);

    public Integer findCountNum(Integer signUserNumber);

    // 0 员工 1 会员 2游客

    public List<Sign> findByPage01(@Param("start") int start, @Param("size") int size,Integer signStatus);

    public List<Sign> findByPage2(@Param("start") int start, @Param("size") int size);

    public List<Sign> findByPageNum(@Param("start") int start, @Param("size") int size,Integer signUserNumber);
    //----
    public List<Sign> findByUserNumber(Integer signUserNumber);

    public Sign findByNum(Integer signUserNumber);

    public void add(Sign sign);
    public void deleteById(Integer singId);
    public void update(Sign sign);

    public Sign findMax();
}
