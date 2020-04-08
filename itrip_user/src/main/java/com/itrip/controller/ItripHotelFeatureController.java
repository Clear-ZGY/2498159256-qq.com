package com.itrip.controller;

import com.itrip.entity.ItripHotelFeature;
import com.itrip.service.ItripHotelFeatureService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (ItripHotelFeature)表控制层
 *
 * @author zgy
 * @since 2020-03-31 17:45:12
 */
@Controller
@RequestMapping("itripHotelFeature")
public class ItripHotelFeatureController {
    /**
     * 服务对象
     */
    @Resource
    private ItripHotelFeatureService itripHotelFeatureService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @RequestMapping("selectOne")
    public ItripHotelFeature selectOne(Long id) {
        return this.itripHotelFeatureService.queryById(id);
    }

}