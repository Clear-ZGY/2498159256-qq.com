package com.itrip.dao;

import com.itrip.entity.ItripUserLinkUser;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (ItripUserLinkUser)表数据库访问层
 *
 * @author zgy
 * @since 2020-03-31 15:22:05
 */
public interface ItripUserLinkUserDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    ItripUserLinkUser queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<ItripUserLinkUser> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param itripUserLinkUser 实例对象
     * @return 对象列表
     */
    List<ItripUserLinkUser> queryAll(ItripUserLinkUser itripUserLinkUser);

    /**
     * 新增数据
     *
     * @param itripUserLinkUser 实例对象
     * @return 影响行数
     */
    int insert(ItripUserLinkUser itripUserLinkUser);

    /**
     * 修改数据
     *
     * @param itripUserLinkUser 实例对象
     * @return 影响行数
     */
    int update(ItripUserLinkUser itripUserLinkUser);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}