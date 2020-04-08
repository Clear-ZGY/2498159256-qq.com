package com.itrip.controller;

import com.itrip.entity.ItripHotCity;
import com.itrip.service.ItripHotCityService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (ItripHotCity)表控制层
 *
 * @author zgy
 * @since 2020-03-31 17:45:12
 */
@Controller
@RequestMapping("itripHotCity")
public class ItripHotCityController {
    /**
     * 服务对象
     */
    @Resource
    private ItripHotCityService itripHotCityService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @RequestMapping("selectOne")
    public ItripHotCity selectOne(String id) {
        return this.itripHotCityService.queryById(id);
    }

}