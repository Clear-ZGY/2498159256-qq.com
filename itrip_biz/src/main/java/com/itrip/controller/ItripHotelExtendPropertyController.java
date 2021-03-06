package com.itrip.controller;

import com.itrip.entity.ItripHotelExtendProperty;
import com.itrip.service.ItripHotelExtendPropertyService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (ItripHotelExtendProperty)表控制层
 *
 * @author zgy
 * @since 2020-03-31 17:45:12
 */
@Controller
@RequestMapping("itripHotelExtendProperty")
public class ItripHotelExtendPropertyController {
    /**
     * 服务对象
     */
    @Resource
    private ItripHotelExtendPropertyService itripHotelExtendPropertyService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @RequestMapping("selectOne")
    public ItripHotelExtendProperty selectOne(Long id) {
        return this.itripHotelExtendPropertyService.queryById(id);
    }

}