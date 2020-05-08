package com.itrip.controller;

import com.itrip.dto.Dto;
import com.itrip.entity.ItripHotel;
import com.itrip.entity.ItripImage;
import com.itrip.service.ItripHotelService;
import com.itrip.utils.DtoUtil;
import com.itrip.utils.ErrorCode;
import com.itrip.vo.ItripImageVO;
import com.itrip.vo.ItripSearchDetailsHotelVO;
import com.itrip.vo.ItripSearchPolicyHotelVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 酒店表(ItripHotel)表控制层
 *
 * @author zgy
 * @since 2020-03-31 17:45:12
 */
@RestController
@RequestMapping("/api/hotel")
@Api(value = "酒店管理相关接口")
public class ItripHotelController {
    /**
     * 服务对象
     */
    @Resource
    private ItripHotelService itripHotelService;

    /**
     * 根据酒店id查询酒店特色和介绍
     *
     * @return 成功：success = ‘true’ | 失败：success = ‘false’ 并返回错误码
     */
    @GetMapping("queryhoteldetails/{id}")
    @ApiOperation(value = "根据酒店id查询酒店特色和介绍（/api/hotel/queryhoteldetails/{id}）", notes = "根据酒店id查询酒店特色和介绍  ", httpMethod = "GET")
    public Dto queryhoteldetails(@ApiParam(name = "id", value = "酒店ID")
                      @PathVariable(value = "id") Integer id) {
        if (id == null) {
            return DtoUtil.returnFail(" false", ErrorCode.HOTEL_ID_IS_EMPTY_GETHOTELDESC);
        } else {
            try {
                Long targetid = Long.valueOf(id);
                List<ItripSearchDetailsHotelVO> hotelDesc = itripHotelService.getHotelDesc(targetid);
                return DtoUtil.returnSuccess("true", hotelDesc);
            } catch (Exception e) {
                e.printStackTrace();
                return DtoUtil.returnFail("false", ErrorCode.SYSTEM_EXCEPTION_GET_FAILED_GETHOTELDESC);
            }
        }
    }

    /**
     * 根据酒店id查询酒店政策
     *
     * @return 成功：success = ‘true’ | 失败：success = ‘false’ 并返回错误码
     */
    @GetMapping("queryhotelpolicy/{id}")
    @ApiOperation(value = "根据酒店id查询酒店政策（/api/hotel/queryhotelpolicy/{id}）", notes = "根据酒店id查询酒店政策", httpMethod = "GET")
    public Dto queryhotelpolicy(@ApiParam(name = "id", value = "酒店ID")
                      @PathVariable(value = "id") Integer id) {
        if (id == null) {
            return DtoUtil.returnFail(" false", ErrorCode.HOTEL_ID_IS_EMPTY_QUERYBYPOLICY);
        } else {
            try {
                Long targetid = Long.valueOf(id);
                List<ItripSearchPolicyHotelVO> itripSearchPolicyHotelVOS = itripHotelService.queryAllByPolicy(targetid);
                return DtoUtil.returnSuccess("true", itripSearchPolicyHotelVOS);
            } catch (Exception e) {
                e.printStackTrace();
                return DtoUtil.returnFail("false", ErrorCode.SYSTEM_EXCEPTION_GET_FAILED_QUERYBYPOLICY);
            }
        }
    }


}