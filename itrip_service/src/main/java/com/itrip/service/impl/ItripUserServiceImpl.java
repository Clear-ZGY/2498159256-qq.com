package com.itrip.service.impl;

import com.itrip.entity.ItripUser;
import com.itrip.dao.ItripUserDao;
import com.itrip.service.ItripUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户表(ItripUser)表服务实现类
 *
 * @author zgy
 * @since 2020-03-31 15:46:29
 */
@Service("itripUserService")
public class ItripUserServiceImpl implements ItripUserService {
    @Resource
    private ItripUserDao itripUserDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public ItripUser queryById(Long id) {
        return this.itripUserDao.queryById(id);
    }

    /**
     * 通过对象名查询单条数据
     *
     * @param userName 主键
     * @return 实例对象
     */
    public ItripUser queryByUserName(String userName){
        return this.itripUserDao.queryByUserName(userName);
    }

    /**
     * 通过对象账号查询单条数据
     *
     * @param userCode 用户账号
     * @return 实例对象
     */
    @Override
    public ItripUser queryByUserCode(String userCode) {
        return this.itripUserDao.queryByUserCode(userCode);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<ItripUser> queryAllByLimit(int offset, int limit) {
        return this.itripUserDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param itripUser 实例对象
     * @return 实例对象
     */
    @Override
    public ItripUser insert(ItripUser itripUser) {
        this.itripUserDao.insert(itripUser);
        return itripUser;
    }

    /**
     * 修改数据
     *
     * @param itripUser 实例对象
     * @return 实例对象
     */
    @Override
    public ItripUser update(ItripUser itripUser) {
        this.itripUserDao.update(itripUser);
        return this.queryById(itripUser.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.itripUserDao.deleteById(id) > 0;
    }
}