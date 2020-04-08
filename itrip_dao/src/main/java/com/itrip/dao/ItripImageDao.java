package com.itrip.dao;

import com.itrip.entity.ItripImage;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 图片表(ItripImage)表数据库访问层
 *
 * @author zgy
 * @since 2020-03-31 15:22:05
 */
public interface ItripImageDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    ItripImage queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<ItripImage> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param itripImage 实例对象
     * @return 对象列表
     */
    List<ItripImage> queryAll(ItripImage itripImage);

    /**
     * 新增数据
     *
     * @param itripImage 实例对象
     * @return 影响行数
     */
    int insert(ItripImage itripImage);

    /**
     * 修改数据
     *
     * @param itripImage 实例对象
     * @return 影响行数
     */
    int update(ItripImage itripImage);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}