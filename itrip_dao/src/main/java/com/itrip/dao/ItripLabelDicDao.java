package com.itrip.dao;

import com.itrip.entity.ItripLabelDic;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 标签字典表(ItripLabelDic)表数据库访问层
 *
 * @author zgy
 * @since 2020-03-31 15:22:05
 */
public interface ItripLabelDicDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    ItripLabelDic queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<ItripLabelDic> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param itripLabelDic 实例对象
     * @return 对象列表
     */
    List<ItripLabelDic> queryAll(ItripLabelDic itripLabelDic);

    /**
     * 新增数据
     *
     * @param itripLabelDic 实例对象
     * @return 影响行数
     */
    int insert(ItripLabelDic itripLabelDic);

    /**
     * 修改数据
     *
     * @param itripLabelDic 实例对象
     * @return 影响行数
     */
    int update(ItripLabelDic itripLabelDic);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}