package com.itrip.controller;

import com.itrip.dto.Dto;
import com.itrip.entity.ItripAreaDic;

import com.itrip.entity.ItripHotel;
import com.itrip.entity.ItripImage;
import com.itrip.service.ItripAreaDicService;
import com.itrip.service.ItripHotelService;
import com.itrip.service.ItripImageService;
import com.itrip.service.ItripLabelDicService;
import com.itrip.utils.DtoUtil;
import com.itrip.utils.ErrorCode;
import com.itrip.vo.*;
import com.mchange.v2.beans.BeansUtils;
import com.sun.tools.javac.util.Assert;
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
 * 区域字典表(ItripAreaDic)表控制层
 *
 * @author zgy
 * @since 2020-03-31 17:45:11
 */
@RestController
@RequestMapping("/api/hotel")
@Api(value = "酒店管理相关接口")
public class ItripAreaDicController {
    /**
     * 服务对象
     */
    @Resource
    private ItripAreaDicService itripAreaDicService;
    @Resource
    private ItripImageService itripImageService;
    @Resource
    private ItripHotelService itripHotelService;
    @Resource
    private ItripLabelDicService itripLabelDicService;

    /**
     * 根据城市查询商圈
     *
     * @return 单条数据
     */
    @GetMapping("querytradearea/{cityId}")
    @ApiOperation(value = "根据城市查询商圈（/api/hotel/querytradearea/{cityId}）", notes = "根据城市查询商圈 ", httpMethod = "GET")
    public Dto querytradearea(@ApiParam(name = "cityId", value = "cityId")
                              @PathVariable(value = "cityId") Integer cityId) {
        if (cityId == null) {
            return DtoUtil.returnFail(" 参数异常或为空", ErrorCode.PARAMETER_IS_NULL);
        }
        //Assert.checkNull(cityId, DtoUtil.returnFail(" 参数异常或为空", ErrorCode.PARAMETER_IS_NULL));
        try {
            List<ItripAreaDicVo> itripAreaDicVos = new ArrayList<>();
            List<ItripAreaDic> hotel = this.itripAreaDicService.queryByParent(cityId);
            for (ItripAreaDic areaDic : hotel) {
                ItripAreaDicVo itripAreaDicVo = new ItripAreaDicVo();
                BeanUtils.copyProperties(areaDic, itripAreaDicVo);
                itripAreaDicVos.add(itripAreaDicVo);
            }
            return DtoUtil.returnSuccess("true", itripAreaDicVos);
        } catch (Exception e) {
            e.printStackTrace();
            return DtoUtil.returnFail("系统异常,获取失败", ErrorCode.SYSTEM_EXCEPTION_GET_FAILED);
        }

    }


    /**
     * 根据targetId查询酒店图片(type=0)
     *
     * @return 成功：success = ‘true’ | 失败：success = ‘false’ 并返回错误码
     */
    @GetMapping("getimg/{targetId}")
    @ApiOperation(value = "根据酒店ID查询酒店图片（/api/hotel/getimg/{targetId}）", notes = "根据酒店ID查询酒店图片 ", httpMethod = "GET")
    public Dto getimg(@ApiParam(name = "targetId", value = "酒店ID")
                      @PathVariable(value = "targetId") String targetId) {
        if (targetId == null) {
            return DtoUtil.returnFail(" false", ErrorCode.HOTEL_ID_IS_EMPTY);
        } else {
            try {
                Long targetid = Long.valueOf(targetId);
                List<ItripImageVO> itripImageVOS = new ArrayList<ItripImageVO>();
                List<ItripImage> itripImageList = this.itripImageService.queryByTargetId(targetid);
                for (ItripImage image : itripImageList) {
                    ItripImageVO itripImageVO = new ItripImageVO();
                    BeanUtils.copyProperties(image, itripImageVO);
                    itripImageVOS.add(itripImageVO);
                }
                return DtoUtil.returnSuccess("true", itripImageVOS);
            } catch (Exception e) {
                e.printStackTrace();
                return DtoUtil.returnFail("false", ErrorCode.FAILED_TO_GET_TH_HOTEL_PICTURE);
            }
        }
    }

    /**
     * 根据酒店id查询酒店设施
     *
     * @return 成功：success = ‘true’ | 失败：success = ‘false’ 并返回错误码
     */
    @GetMapping("queryhotelfacilities/{id}")
    @ApiOperation(value = "根据酒店id查询酒店设施（/api/hotel/queryhotelfacilities/{id}）", notes = "根据酒店id查询酒店设施 ", httpMethod = "GET")
    public Dto queryhotelfacilities(@ApiParam(name = "id", value = "酒店ID")
                                    @PathVariable(value = "id") Integer id) {
        if (id == null) {
            return DtoUtil.returnFail(" false", ErrorCode.HOTEL_ID_IS_EMPTY_QUERYHOTELFACILITIES);
        } else {
            try {
                Long id1 = Long.valueOf(id);
                ItripSearchFacilitiesHotelVO itripSearchFacilitiesHotelVO = new ItripSearchFacilitiesHotelVO();
                ItripHotel hotel = this.itripHotelService.queryById(id1);
                BeanUtils.copyProperties(hotel, itripSearchFacilitiesHotelVO);
                return DtoUtil.returnSuccess("true", itripSearchFacilitiesHotelVO);
            } catch (Exception e) {
                e.printStackTrace();
                return DtoUtil.returnFail("false", ErrorCode.SYSTEM_EXCEPTION_GET_FAILED_QUERYHOTELFACILITIES);
            }
        }
    }

    /**
     * 根据酒店id查询酒店特色、商圈、酒店名称
     *
     * @return 成功：success = ‘true’ | 失败：success = ‘false’ 并返回错误码
     */
    @GetMapping("getvideodesc/{hotelId}")
    @ApiOperation(value = "根据酒店id查询酒店特色、商圈、酒店名称（/api/hotel/getvideodesc/{hotelId}）", notes = "根据酒店id查询酒店特色、商圈、酒店名称 ", httpMethod = "GET")
    public Dto getvideodesc(@ApiParam(name = "hotelId", value = "酒店ID")
                            @PathVariable(value = "hotelId") String hotelId) {
        if (hotelId == null) {
            return DtoUtil.returnFail(" false", ErrorCode.HOTEL_ID_IS_EMPTY_GETVIDEODESC);
        } else {
            try {
                Long id1 = Long.valueOf(hotelId);
                HotelVideoDescVO hotelVideoDescVO = this.itripHotelService.getHotelVideoDesc(id1);
                return DtoUtil.returnSuccess("true", hotelVideoDescVO);
            } catch (Exception e) {
                e.printStackTrace();
                return DtoUtil.returnFail("false", ErrorCode.FAILED_TO_GET_HOTEL_VIDEO_TEXT_DESCRIPTION);
            }
        }
    }

    /**
     * 查询酒店特色列表
     *
     * @return 成功：success = ‘true’ | 失败：success = ‘false’ 并返回错误码
     */
    @GetMapping("queryhotelfeature")
    @ApiOperation(value = "查询酒店特色列表（/api/hotel/queryhotelfeature）", notes = "查询酒店特色列表", httpMethod = "GET")
    public Dto queryhotelfeature() {
        try {
            //酒店特色
            Long parentId = 16L;
            List<ItripLabelDicVO> itripLabelDicVOList = this.itripLabelDicService.queryByParentId(parentId);
            return DtoUtil.returnSuccess("true", itripLabelDicVOList);
        } catch (Exception e) {
            e.printStackTrace();
            return DtoUtil.returnFail("false", ErrorCode.SYSTEM_EXCEPTION_GET_FAILED_QUERYBYPARENTID);
        }
    }

    /**
     * 查询热门城市
     *
     * @return 成功：success = ‘true’ | 失败：success = ‘false’ 并返回错误码
     */
    @GetMapping("queryhotcity/{type}")
    @ApiOperation(value = "查询热门城市（/api/hotel/queryhotcity/{type}）", notes = "查询热门城市", httpMethod = "GET")
    public Dto queryhotcity(@ApiParam(name = "type", value = "type")
                            @PathVariable(value = "type") Integer type) {
        if (type == null) {
            return DtoUtil.returnFail("false", ErrorCode.PARAMETER_IS_NULL_QUERYBUTYPE);
        } else {
            try {
                List<ItripAreaDicVo> itripAreaDicsVo = this.itripAreaDicService.queryByType(type);
                return DtoUtil.returnSuccess("true", itripAreaDicsVo);
            } catch (Exception e) {
                e.printStackTrace();
                return DtoUtil.returnFail("false", ErrorCode.SYSTEM_EXCEPTION_GET_FAILED_QUERYBUTYPE);
            }
        }
    }
}