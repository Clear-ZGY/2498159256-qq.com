package com.itrip.controller;

import com.itrip.entity.ItripAreaDic;

import com.itrip.service.ItripAreaDicService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 区域字典表(ItripAreaDic)表控制层
 *
 * @author zgy
 * @since 2020-03-31 17:45:11
 */
@Controller
@RequestMapping("itripAreaDic")
public class ItripAreaDicController {
    /**
     * 服务对象
     */
    @Resource
    private ItripAreaDicService itripAreaDicService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @RequestMapping("selectOne")
    public ItripAreaDic selectOne(Long id) {
        return this.itripAreaDicService.queryById(id);
    }

}