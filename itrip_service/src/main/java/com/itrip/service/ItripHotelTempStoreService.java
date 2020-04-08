package com.itrip.service;

import com.itrip.entity.ItripHotelTempStore;
import java.util.List;

/**
 * 实时库存表(ItripHotelTempStore)表服务接口
 *
 * @author zgy
 * @since 2020-03-31 15:46:29
 */
public interface ItripHotelTempStoreService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    ItripHotelTempStore queryById(Long id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<ItripHotelTempStore> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param itripHotelTempStore 实例对象
     * @return 实例对象
     */
    ItripHotelTempStore insert(ItripHotelTempStore itripHotelTempStore);

    /**
     * 修改数据
     *
     * @param itripHotelTempStore 实例对象
     * @return 实例对象
     */
    ItripHotelTempStore update(ItripHotelTempStore itripHotelTempStore);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}