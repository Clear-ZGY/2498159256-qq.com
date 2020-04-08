package com.itrip.controller;

import com.itrip.entity.ItripHotelRoom;
import com.itrip.service.ItripHotelRoomService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 酒店房间表(ItripHotelRoom)表控制层
 *
 * @author zgy
 * @since 2020-03-31 17:45:12
 */
@Controller
@RequestMapping("itripHotelRoom")
public class ItripHotelRoomController {
    /**
     * 服务对象
     */
    @Resource
    private ItripHotelRoomService itripHotelRoomService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @RequestMapping("selectOne")
    public ItripHotelRoom selectOne(Long id) {
        return this.itripHotelRoomService.queryById(id);
    }

}