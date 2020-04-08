package com.itrip.controller;

import com.itrip.entity.ItripHotKeyword;
import com.itrip.service.ItripHotKeywordService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (ItripHotKeyword)表控制层
 *
 * @author zgy
 * @since 2020-03-31 17:45:12
 */
@Controller
@RequestMapping("itripHotKeyword")
public class ItripHotKeywordController {
    /**
     * 服务对象
     */
    @Resource
    private ItripHotKeywordService itripHotKeywordService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @RequestMapping("selectOne")
    public ItripHotKeyword selectOne(String id) {
        return this.itripHotKeywordService.queryById(id);
    }

}