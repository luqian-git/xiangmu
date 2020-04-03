package com.zhiyou100.gym.service;


import com.zhiyou100.gym.pojo.Cabinet;

import java.util.List;

public interface CabinetService {

    public List<Cabinet> findYAll();
    public List<Cabinet> findWAll();
    public Cabinet findById(Integer usId);
    public String add(Cabinet user);
    public String deleteById(Integer usId);
    public String update(Cabinet user);

    public void update1 (Integer cabId);
    public void update3 (Integer cabId);
}
