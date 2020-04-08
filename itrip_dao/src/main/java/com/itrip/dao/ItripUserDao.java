package com.itrip.dao;

import com.itrip.entity.ItripUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 用户表(ItripUser)表数据库访问层
 *
 * @author zgy
 * @since 2020-03-31 15:22:05
 */
public interface ItripUserDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    ItripUser queryById(Long id);

    /**
     * 通过对象名查询单条数据
     *
     * @param userName 用户名
     * @return 实例对象
     */
    ItripUser queryByUserName(String userName);

    /**
     * 通过对象账号查询单条数据
     *
     * @param userCode 用户账号
     * @return 实例对象
     */
    ItripUser queryByUserCode(String userCode);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<ItripUser> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param itripUser 实例对象
     * @return 对象列表
     */
    List<ItripUser> queryAll(ItripUser itripUser);

    /**
     * 新增数据
     *
     * @param itripUser 实例对象
     * @return 影响行数
     */
    int insert(ItripUser itripUser);

    /**
     * 修改数据
     *
     * @param itripUser 实例对象
     * @return 影响行数
     */
    int update(ItripUser itripUser);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}