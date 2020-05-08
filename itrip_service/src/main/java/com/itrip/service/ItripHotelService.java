package com.itrip.service;

import com.itrip.entity.ItripHotel;
import com.itrip.vo.HotelVideoDescVO;
import com.itrip.vo.ItripSearchDetailsHotelVO;
import com.itrip.vo.ItripSearchPolicyHotelVO;

import java.util.List;

/**
 * 酒店表(ItripHotel)表服务接口
 *
 * @author zgy
 * @since 2020-03-31 15:46:29
 */
public interface ItripHotelService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    ItripHotel queryById(Long id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<ItripHotel> queryAllByLimit(int offset, int limit);

    /**
     * 根据酒店Id查询酒店政策
     *
     * @param id 酒店Id
     * @return 对象列表
     */
    List<ItripSearchPolicyHotelVO> queryAllByPolicy(Long id);

    /**
     * 新增数据
     *
     * @param itripHotel 实例对象
     * @return 实例对象
     */
    ItripHotel insert(ItripHotel itripHotel);

    /**
     * 修改数据
     *
     * @param itripHotel 实例对象
     * @return 实例对象
     */
    ItripHotel update(ItripHotel itripHotel);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

    /**
     * 根据酒店Id获取酒店名称、周围商圈、特色
     * @param targetId 酒店Id
     * @return
     */
    HotelVideoDescVO getHotelVideoDesc(Long targetId);

    /**
     * 根据酒店Id获取酒店特色及介绍
     * @param targetId 酒店Id
     * @return
     */
    List<ItripSearchDetailsHotelVO> getHotelDesc(Long targetId);

}