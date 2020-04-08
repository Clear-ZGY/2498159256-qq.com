package com.itrip.service.impl;

import com.itrip.entity.ItripOrderLinkUser;
import com.itrip.dao.ItripOrderLinkUserDao;
import com.itrip.service.ItripOrderLinkUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (ItripOrderLinkUser)表服务实现类
 *
 * @author zgy
 * @since 2020-03-31 15:46:29
 */
@Service("itripOrderLinkUserService")
public class ItripOrderLinkUserServiceImpl implements ItripOrderLinkUserService {
    @Resource
    private ItripOrderLinkUserDao itripOrderLinkUserDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public ItripOrderLinkUser queryById(Long id) {
        return this.itripOrderLinkUserDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<ItripOrderLinkUser> queryAllByLimit(int offset, int limit) {
        return this.itripOrderLinkUserDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param itripOrderLinkUser 实例对象
     * @return 实例对象
     */
    @Override
    public ItripOrderLinkUser insert(ItripOrderLinkUser itripOrderLinkUser) {
        this.itripOrderLinkUserDao.insert(itripOrderLinkUser);
        return itripOrderLinkUser;
    }

    /**
     * 修改数据
     *
     * @param itripOrderLinkUser 实例对象
     * @return 实例对象
     */
    @Override
    public ItripOrderLinkUser update(ItripOrderLinkUser itripOrderLinkUser) {
        this.itripOrderLinkUserDao.update(itripOrderLinkUser);
        return this.queryById(itripOrderLinkUser.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.itripOrderLinkUserDao.deleteById(id) > 0;
    }
}