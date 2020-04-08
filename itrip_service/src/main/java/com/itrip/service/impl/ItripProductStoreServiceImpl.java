package com.itrip.service.impl;

import com.itrip.entity.ItripProductStore;
import com.itrip.dao.ItripProductStoreDao;
import com.itrip.service.ItripProductStoreService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 原始库存表(ItripProductStore)表服务实现类
 *
 * @author zgy
 * @since 2020-03-31 15:46:29
 */
@Service("itripProductStoreService")
public class ItripProductStoreServiceImpl implements ItripProductStoreService {
    @Resource
    private ItripProductStoreDao itripProductStoreDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public ItripProductStore queryById(Long id) {
        return this.itripProductStoreDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<ItripProductStore> queryAllByLimit(int offset, int limit) {
        return this.itripProductStoreDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param itripProductStore 实例对象
     * @return 实例对象
     */
    @Override
    public ItripProductStore insert(ItripProductStore itripProductStore) {
        this.itripProductStoreDao.insert(itripProductStore);
        return itripProductStore;
    }

    /**
     * 修改数据
     *
     * @param itripProductStore 实例对象
     * @return 实例对象
     */
    @Override
    public ItripProductStore update(ItripProductStore itripProductStore) {
        this.itripProductStoreDao.update(itripProductStore);
        return this.queryById(itripProductStore.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.itripProductStoreDao.deleteById(id) > 0;
    }
}