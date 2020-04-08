package com.itrip.service;

import com.itrip.entity.ItripProductStore;
import java.util.List;

/**
 * 原始库存表(ItripProductStore)表服务接口
 *
 * @author zgy
 * @since 2020-03-31 15:46:29
 */
public interface ItripProductStoreService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    ItripProductStore queryById(Long id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<ItripProductStore> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param itripProductStore 实例对象
     * @return 实例对象
     */
    ItripProductStore insert(ItripProductStore itripProductStore);

    /**
     * 修改数据
     *
     * @param itripProductStore 实例对象
     * @return 实例对象
     */
    ItripProductStore update(ItripProductStore itripProductStore);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}