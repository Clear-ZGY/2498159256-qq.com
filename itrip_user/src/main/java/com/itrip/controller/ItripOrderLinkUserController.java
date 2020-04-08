package com.itrip.controller;

import com.itrip.entity.ItripOrderLinkUser;
import com.itrip.service.ItripOrderLinkUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (ItripOrderLinkUser)表控制层
 *
 * @author zgy
 * @since 2020-03-31 17:45:12
 */
@Controller
@RequestMapping("itripOrderLinkUser")
public class ItripOrderLinkUserController {
    /**
     * 服务对象
     */
    @Resource
    private ItripOrderLinkUserService itripOrderLinkUserService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @RequestMapping("selectOne")
    public ItripOrderLinkUser selectOne(Long id) {
        return this.itripOrderLinkUserService.queryById(id);
    }

}