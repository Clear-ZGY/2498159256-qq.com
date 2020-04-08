package com.itrip.controller;

import com.itrip.entity.ItripHotelTradingArea;
import com.itrip.service.ItripHotelTradingAreaService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (ItripHotelTradingArea)表控制层
 *
 * @author zgy
 * @since 2020-03-31 17:45:12
 */
@Controller
@RequestMapping("itripHotelTradingArea")
public class ItripHotelTradingAreaController {
    /**
     * 服务对象
     */
    @Resource
    private ItripHotelTradingAreaService itripHotelTradingAreaService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @RequestMapping("selectOne")
    public ItripHotelTradingArea selectOne(Long id) {
        return this.itripHotelTradingAreaService.queryById(id);
    }

}