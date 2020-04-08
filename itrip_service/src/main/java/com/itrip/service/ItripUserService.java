package com.itrip.service;

import com.itrip.entity.ItripUser;
import java.util.List;

/**
 * 用户表(ItripUser)表服务接口
 *
 * @author zgy
 * @since 2020-03-31 15:46:29
 */
public interface ItripUserService {

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
     * @param userName 主键
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
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<ItripUser> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param itripUser 实例对象
     * @return 实例对象
     */
    ItripUser insert(ItripUser itripUser);

    /**
     * 修改数据
     *
     * @param itripUser 实例对象
     * @return 实例对象
     */
    ItripUser update(ItripUser itripUser);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}