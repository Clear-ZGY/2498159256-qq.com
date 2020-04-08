package com.itrip.controller;

import com.itrip.entity.ItripTradeEnds;
import com.itrip.service.ItripTradeEndsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 订单支付完成后，系统需对该订单进行后续处理，如减库存等。处理完成后，删除此表中的订单记录(ItripTradeEnds)表控制层
 *
 * @author zgy
 * @since 2020-03-31 17:45:12
 */
@Controller
@RequestMapping("itripTradeEnds")
public class ItripTradeEndsController {
    /**
     * 服务对象
     */
    @Resource
    private ItripTradeEndsService itripTradeEndsService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @RequestMapping("selectOne")
    public ItripTradeEnds selectOne(Long id) {
        return this.itripTradeEndsService.queryById(id);
    }

}