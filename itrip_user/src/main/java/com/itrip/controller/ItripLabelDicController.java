package com.itrip.controller;

import com.itrip.entity.ItripLabelDic;
import com.itrip.service.ItripLabelDicService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 标签字典表(ItripLabelDic)表控制层
 *
 * @author zgy
 * @since 2020-03-31 17:45:12
 */
@Controller
@RequestMapping("itripLabelDic")
public class ItripLabelDicController {
    /**
     * 服务对象
     */
    @Resource
    private ItripLabelDicService itripLabelDicService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @RequestMapping("selectOne")
    public ItripLabelDic selectOne(Long id) {
        return this.itripLabelDicService.queryById(id);
    }

}