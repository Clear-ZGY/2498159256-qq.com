package com.itrip.dao;

import com.itrip.entity.ItripHotelExtendProperty;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (ItripHotelExtendProperty)表数据库访问层
 *
 * @author zgy
 * @since 2020-03-31 15:22:05
 */
public interface ItripHotelExtendPropertyDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    ItripHotelExtendProperty queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<ItripHotelExtendProperty> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param itripHotelExtendProperty 实例对象
     * @return 对象列表
     */
    List<ItripHotelExtendProperty> queryAll(ItripHotelExtendProperty itripHotelExtendProperty);

    /**
     * 新增数据
     *
     * @param itripHotelExtendProperty 实例对象
     * @return 影响行数
     */
    int insert(ItripHotelExtendProperty itripHotelExtendProperty);

    /**
     * 修改数据
     *
     * @param itripHotelExtendProperty 实例对象
     * @return 影响行数
     */
    int update(ItripHotelExtendProperty itripHotelExtendProperty);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}