package com.itrip.controller;

import com.itrip.entity.ItripImage;
import com.itrip.service.ItripImageService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 图片表(ItripImage)表控制层
 *
 * @author zgy
 * @since 2020-03-31 17:45:12
 */
@Controller
@RequestMapping("itripImage")
public class ItripImageController {
    /**
     * 服务对象
     */
    @Resource
    private ItripImageService itripImageService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @RequestMapping("selectOne")
    public ItripImage selectOne(Long id) {
        return this.itripImageService.queryById(id);
    }

}