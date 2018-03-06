package com.leadbank.region.dao;

import com.leadbank.region.entity.Area;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

/**
 * 下面注释表示利用Spring junit test去跑程序，会启动Spring boot服务
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AreaMapperTest {

    @Autowired
    private AreaDao areaDao;

    @Test
    @Ignore
    public void queryAreaList() throws Exception {
        List<Area> areaList = areaDao.queryAreaList();
        Assert.assertEquals(0,areaList.size());
    }

    @Test
    public void queryAreaById() throws Exception {
        Area area = areaDao.queryAreaById(1);
        System.out.println(area.getAreaName());
        System.out.println(area.getPriority());
        System.out.println(area.getCreatedTime());
    }

    @Test
    @Ignore
    public void insertArea() throws Exception {
        Area area = new Area();
        area.setAreaName("北京");
        area.setPriority(9);
        area.setCreatedTime(new Date());
        int result = areaDao.insertArea(area);
        Assert.assertEquals(1,result);
    }

    @Test
    @Ignore
    public void updateArea() throws Exception {
    }

    @Test
    @Ignore
    public void deleteArea() throws Exception {
    }


}