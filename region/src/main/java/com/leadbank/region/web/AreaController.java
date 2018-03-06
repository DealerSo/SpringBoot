package com.leadbank.region.web;

import com.leadbank.region.entity.Area;
import com.leadbank.region.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class AreaController {

    @Autowired
    private AreaService areaService;

    @RequestMapping(value = "/listArea", method = RequestMethod.GET)
    public Map<String, Object> listArea() {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        List<Area> listArea = areaService.getAreaList();
        modelMap.put("listArea", listArea);
        return modelMap;
    }

    @RequestMapping(value = "/getAreaInfo/{areaId}", method = RequestMethod.GET)
    public Map<String, Object> getAreaInfo(@PathVariable Integer areaId) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        Area area = areaService.getAreaById(areaId);
        modelMap.put("area", area);
        return modelMap;
    }
}
