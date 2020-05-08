package com.itrip.service.impl;

import com.itrip.dao.ItripAreaDicDao;
import com.itrip.dao.ItripHotelFeatureDao;
import com.itrip.entity.*;
import com.itrip.dao.ItripHotelDao;
import com.itrip.service.ItripHotelService;
import com.itrip.vo.HotelVideoDescVO;
import com.itrip.vo.ItripSearchDetailsHotelVO;
import com.itrip.vo.ItripSearchPolicyHotelVO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 酒店表(ItripHotel)表服务实现类
 *
 * @author zgy
 * @since 2020-03-31 15:46:29
 */
@Service("itripHotelService")
public class ItripHotelServiceImpl implements ItripHotelService {
    @Resource
    private ItripHotelDao itripHotelDao;
    @Resource
    private ItripHotelFeatureDao itripHotelFeatureDao;
    @Resource
    private ItripAreaDicDao itripAreaDicDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public ItripHotel queryById(Long id) {
        return this.itripHotelDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<ItripHotel> queryAllByLimit(int offset, int limit) {
        return this.itripHotelDao.queryAllByLimit(offset, limit);
    }

    /**
     * 根据酒店Id查询酒店政策
     *
     * @param id 酒店Id
     * @return 对象列表
     */
    @Override
    public List<ItripSearchPolicyHotelVO> queryAllByPolicy(Long id) {
        List<ItripSearchPolicyHotelVO> itripSearchPolicyHotelVOS = new ArrayList<>();
        ItripHotel itripHotel = new ItripHotel();
        itripHotel.setId(id);
        List<ItripHotel> itripHotels = itripHotelDao.queryAll(itripHotel);
        for (ItripHotel hotel:itripHotels) {
            ItripSearchPolicyHotelVO itripSearchPolicyHotelVO = new ItripSearchPolicyHotelVO();
            BeanUtils.copyProperties(hotel,itripSearchPolicyHotelVO);
            itripSearchPolicyHotelVOS.add(itripSearchPolicyHotelVO);
        }
        return itripSearchPolicyHotelVOS;
    }

    /**
     * 新增数据
     *
     * @param itripHotel 实例对象
     * @return 实例对象
     */
    @Override
    public ItripHotel insert(ItripHotel itripHotel) {
        this.itripHotelDao.insert(itripHotel);
        return itripHotel;
    }

    /**
     * 修改数据
     *
     * @param itripHotel 实例对象
     * @return 实例对象
     */
    @Override
    public ItripHotel update(ItripHotel itripHotel) {
        this.itripHotelDao.update(itripHotel);
        return this.queryById(itripHotel.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.itripHotelDao.deleteById(id) > 0;
    }

    /**
     * 根据酒店Id获取酒店名称、周围商圈、特色
     *
     * @param targetId 酒店Id
     * @return
     */
    @Override
    public HotelVideoDescVO getHotelVideoDesc(Long targetId) {
        HotelVideoDescVO hotelVideoDescVO = new HotelVideoDescVO();
        List<String> hotelfeaturelist = new ArrayList<>();
        List<String> tradingareanameList = new ArrayList<>();
        //根据酒店ID获取酒店对象
        ItripHotel hotel = itripHotelDao.queryById(targetId);
        //获取酒店名称
        hotelVideoDescVO.setHotelname(hotel.getHotelname());
        //根据酒店ID获取酒店特色
        ItripHotelFeature itripHotelFeature = itripHotelFeatureDao.queryByHotelId(targetId);
        for (ItripLabelDic labelDic:itripHotelFeature.getItripLabelDicList()) {
            hotelfeaturelist.add(labelDic.getName());
        }
        //获取酒店特色
        hotelVideoDescVO.setHotelfeaturelist(hotelfeaturelist);
        ItripHotelTradingArea itripHotelTradingArea = itripAreaDicDao.queryByHotelId(targetId);
        for (ItripAreaDic itripAreaDic:itripHotelTradingArea.getItripAreaDicList()) {
            tradingareanameList.add(itripAreaDic.getName());
        }
        //获取商圈
        //获取酒店特色
        hotelVideoDescVO.setTradingareanameList(tradingareanameList);
        return hotelVideoDescVO;
    }

    /**
     * 根据酒店Id获取酒店特色及介绍
     *
     * @param targetId 酒店Id
     * @return
     */
    @Override
    public List<ItripSearchDetailsHotelVO> getHotelDesc(Long targetId) {
        List<ItripSearchDetailsHotelVO> itripSearchDetailsHotelVOS = new ArrayList<>();
        //获取酒店特色及介绍
        ItripHotelFeature itripHotelFeature = itripHotelFeatureDao.queryByHotelId(targetId);
        for (ItripLabelDic labelDic:itripHotelFeature.getItripLabelDicList()) {
            ItripSearchDetailsHotelVO itripSearchDetailsHotelVO = new ItripSearchDetailsHotelVO();
            BeanUtils.copyProperties(labelDic,itripSearchDetailsHotelVO);
            itripSearchDetailsHotelVOS.add(itripSearchDetailsHotelVO);
        }
        return itripSearchDetailsHotelVOS;
    }
}