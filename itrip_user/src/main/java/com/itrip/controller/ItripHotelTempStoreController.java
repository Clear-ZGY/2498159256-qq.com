package com.itrip.controller;

import com.itrip.entity.ItripHotelTempStore;
import com.itrip.service.ItripHotelTempStoreService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 实时库存表(ItripHotelTempStore)表控制层
 *
 * @author zgy
 * @since 2020-03-31 17:45:12
 */
@Controller
@RequestMapping("itripHotelTempStore")
public class ItripHotelTempStoreController {
    /**
     * 服务对象
     */
    @Resource
    private ItripHotelTempStoreService itripHotelTempStoreService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @RequestMapping("selectOne")
    public ItripHotelTempStore selectOne(Long id) {
        return this.itripHotelTempStoreService.queryById(id);
    }

}