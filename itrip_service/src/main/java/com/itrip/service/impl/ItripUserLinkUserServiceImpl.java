package com.itrip.service.impl;

import com.itrip.entity.ItripUserLinkUser;
import com.itrip.dao.ItripUserLinkUserDao;
import com.itrip.service.ItripUserLinkUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (ItripUserLinkUser)表服务实现类
 *
 * @author zgy
 * @since 2020-03-31 15:46:29
 */
@Service("itripUserLinkUserService")
public class ItripUserLinkUserServiceImpl implements ItripUserLinkUserService {
    @Resource
    private ItripUserLinkUserDao itripUserLinkUserDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public ItripUserLinkUser queryById(Long id) {
        return this.itripUserLinkUserDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<ItripUserLinkUser> queryAllByLimit(int offset, int limit) {
        return this.itripUserLinkUserDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param itripUserLinkUser 实例对象
     * @return 实例对象
     */
    @Override
    public ItripUserLinkUser insert(ItripUserLinkUser itripUserLinkUser) {
        this.itripUserLinkUserDao.insert(itripUserLinkUser);
        return itripUserLinkUser;
    }

    /**
     * 修改数据
     *
     * @param itripUserLinkUser 实例对象
     * @return 实例对象
     */
    @Override
    public ItripUserLinkUser update(ItripUserLinkUser itripUserLinkUser) {
        this.itripUserLinkUserDao.update(itripUserLinkUser);
        return this.queryById(itripUserLinkUser.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.itripUserLinkUserDao.deleteById(id) > 0;
    }
}