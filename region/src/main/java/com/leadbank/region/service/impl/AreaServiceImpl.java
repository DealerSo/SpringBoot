package com.leadbank.region.service.impl;

import com.leadbank.region.dao.AreaDao;
import com.leadbank.region.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AreaServiceImpl implements AreaService{

    @Autowired
    private AreaDao areaMapper;
}
