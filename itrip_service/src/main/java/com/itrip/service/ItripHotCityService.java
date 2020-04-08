package com.itrip.service;

import com.itrip.entity.ItripHotCity;
import java.util.List;

/**
 * (ItripHotCity)表服务接口
 *
 * @author zgy
 * @since 2020-03-31 15:46:29
 */
public interface ItripHotCityService {

    /**
     * 通过ID查询单条数据
     *
     * @param city 主键
     * @return 实例对象
     */
    ItripHotCity queryById(String city);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<ItripHotCity> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param itripHotCity 实例对象
     * @return 实例对象
     */
    ItripHotCity insert(ItripHotCity itripHotCity);

    /**
     * 修改数据
     *
     * @param itripHotCity 实例对象
     * @return 实例对象
     */
    ItripHotCity update(ItripHotCity itripHotCity);

    /**
     * 通过主键删除数据
     *
     * @param city 主键
     * @return 是否成功
     */
    boolean deleteById(String city);

}