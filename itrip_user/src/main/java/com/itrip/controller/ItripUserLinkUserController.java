package com.itrip.controller;

import com.itrip.entity.ItripUserLinkUser;
import com.itrip.service.ItripUserLinkUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (ItripUserLinkUser)表控制层
 *
 * @author zgy
 * @since 2020-03-31 17:45:12
 */
@Controller
@RequestMapping("itripUserLinkUser")
public class ItripUserLinkUserController {
    /**
     * 服务对象
     */
    @Resource
    private ItripUserLinkUserService itripUserLinkUserService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @RequestMapping("selectOne")
    public ItripUserLinkUser selectOne(Long id) {
        return this.itripUserLinkUserService.queryById(id);
    }

}