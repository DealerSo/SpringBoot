package com.leadbank.region.service.impl;

import com.leadbank.region.dao.AreaDao;
import com.leadbank.region.entity.Area;
import com.leadbank.region.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;

@Service
public class AreaServiceImpl implements AreaService {

    @Autowired
    private AreaDao areaDao;

    @Override
    public List<Area> getAreaList() {
        return areaDao.queryAreaList();
    }

    @Override
    public Area getAreaById(int areaId) {
        return areaDao.queryAreaById(areaId);
    }

    @Override
    // 加入事务处理
    @Transactional
    public boolean addArea(Area area) {
        if (!StringUtils.isEmpty(area.getAreaName())) {
            Date now = new Date();
            if(StringUtils.isEmpty(area.getPriority())){
                area.setPriority(1);  //默认优先级设置为1
            }
            area.setCreatedTime(now);
            try {
                int effectedRow = areaDao.insertArea(area);
                if (effectedRow > 0) {
                   return true;
                }else{
                    throw new RuntimeException("插入区域信息失败!");
                }
            } catch (Exception e) {
                throw new RuntimeException("插入区域信息失败!" + e.getMessage());
            }
        } else {
            throw new RuntimeException("区域信息不能为空!");
        }
    }

    @Override
    public boolean modifyArea(Area area) {
        return false;
    }

    @Override
    public boolean deleteArea(int areaId) {
        return false;
    }
}
