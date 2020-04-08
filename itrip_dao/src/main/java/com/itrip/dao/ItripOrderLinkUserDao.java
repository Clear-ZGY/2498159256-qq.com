package com.itrip.dao;

import com.itrip.entity.ItripOrderLinkUser;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (ItripOrderLinkUser)表数据库访问层
 *
 * @author zgy
 * @since 2020-03-31 15:22:05
 */
public interface ItripOrderLinkUserDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    ItripOrderLinkUser queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<ItripOrderLinkUser> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param itripOrderLinkUser 实例对象
     * @return 对象列表
     */
    List<ItripOrderLinkUser> queryAll(ItripOrderLinkUser itripOrderLinkUser);

    /**
     * 新增数据
     *
     * @param itripOrderLinkUser 实例对象
     * @return 影响行数
     */
    int insert(ItripOrderLinkUser itripOrderLinkUser);

    /**
     * 修改数据
     *
     * @param itripOrderLinkUser 实例对象
     * @return 影响行数
     */
    int update(ItripOrderLinkUser itripOrderLinkUser);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}