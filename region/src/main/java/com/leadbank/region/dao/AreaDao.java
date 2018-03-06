package com.leadbank.region.dao;

import com.leadbank.region.entity.Area;

import java.util.List;

public interface AreaDao {

    /**
     * 查询所有area信息
     *
     * @return
     */
    List<Area> queryAreaList();

    /**
     * 通过主键查询area信息
     *
     * @param areaId
     * @return
     */
    Area queryAreaById(int areaId);

    /**
     * 添加area信息
     *
     * @param area
     * @return
     */
    int insertArea(Area area);

    /**
     * 更新area信息
     *
     * @param area
     * @return
     */
    int updateArea(Area area);

    /**
     * 通过主键删除area信息
     *
     * @param areaId
     * @return
     */
    int deleteArea(int areaId);

}
