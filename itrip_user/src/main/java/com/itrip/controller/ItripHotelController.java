package com.itrip.controller;

import com.itrip.entity.ItripHotel;
import com.itrip.service.ItripHotelService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 酒店表(ItripHotel)表控制层
 *
 * @author zgy
 * @since 2020-03-31 17:45:12
 */
@Controller
@RequestMapping("itripHotel")
public class ItripHotelController {
    /**
     * 服务对象
     */
    @Resource
    private ItripHotelService itripHotelService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @RequestMapping("selectOne")
    public ItripHotel selectOne(Long id) {
        return this.itripHotelService.queryById(id);
    }

}