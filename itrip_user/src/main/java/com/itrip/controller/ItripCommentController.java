package com.itrip.controller;

import com.itrip.entity.ItripComment;
import com.itrip.service.ItripCommentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 评论表(ItripComment)表控制层
 *
 * @author zgy
 * @since 2020-03-31 17:45:12
 */
@Controller
@RequestMapping("itripComment")
public class ItripCommentController {
    /**
     * 服务对象
     */
    @Resource
    private ItripCommentService itripCommentService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @RequestMapping("selectOne")
    public ItripComment selectOne(Long id) {
        return this.itripCommentService.queryById(id);
    }

}