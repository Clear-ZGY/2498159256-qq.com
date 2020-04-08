package com.itrip.dao;

import com.itrip.entity.ItripHotCity;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (ItripHotCity)表数据库访问层
 *
 * @author zgy
 * @since 2020-03-31 15:22:05
 */
public interface ItripHotCityDao {

    /**
     * 通过ID查询单条数据
     *
     * @param city 主键
     * @return 实例对象
     */
    ItripHotCity queryById(String city);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<ItripHotCity> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param itripHotCity 实例对象
     * @return 对象列表
     */
    List<ItripHotCity> queryAll(ItripHotCity itripHotCity);

    /**
     * 新增数据
     *
     * @param itripHotCity 实例对象
     * @return 影响行数
     */
    int insert(ItripHotCity itripHotCity);

    /**
     * 修改数据
     *
     * @param itripHotCity 实例对象
     * @return 影响行数
     */
    int update(ItripHotCity itripHotCity);

    /**
     * 通过主键删除数据
     *
     * @param city 主键
     * @return 影响行数
     */
    int deleteById(String city);

}