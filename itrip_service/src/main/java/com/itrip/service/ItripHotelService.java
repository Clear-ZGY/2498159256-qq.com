package com.itrip.service;

import com.itrip.entity.ItripHotel;
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

}