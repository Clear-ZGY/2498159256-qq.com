package com.itrip.controller;

import com.itrip.entity.ItripProductStore;
import com.itrip.service.ItripProductStoreService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 原始库存表(ItripProductStore)表控制层
 *
 * @author zgy
 * @since 2020-03-31 17:45:12
 */
@Controller
@RequestMapping("itripProductStore")
public class ItripProductStoreController {
    /**
     * 服务对象
     */
    @Resource
    private ItripProductStoreService itripProductStoreService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @RequestMapping("selectOne")
    public ItripProductStore selectOne(Long id) {
        return this.itripProductStoreService.queryById(id);
    }

}