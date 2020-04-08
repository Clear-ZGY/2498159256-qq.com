package com.itrip.service.impl;

import com.itrip.entity.ItripHotelTempStore;
import com.itrip.dao.ItripHotelTempStoreDao;
import com.itrip.service.ItripHotelTempStoreService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 实时库存表(ItripHotelTempStore)表服务实现类
 *
 * @author zgy
 * @since 2020-03-31 15:46:29
 */
@Service("itripHotelTempStoreService")
public class ItripHotelTempStoreServiceImpl implements ItripHotelTempStoreService {
    @Resource
    private ItripHotelTempStoreDao itripHotelTempStoreDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public ItripHotelTempStore queryById(Long id) {
        return this.itripHotelTempStoreDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<ItripHotelTempStore> queryAllByLimit(int offset, int limit) {
        return this.itripHotelTempStoreDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param itripHotelTempStore 实例对象
     * @return 实例对象
     */
    @Override
    public ItripHotelTempStore insert(ItripHotelTempStore itripHotelTempStore) {
        this.itripHotelTempStoreDao.insert(itripHotelTempStore);
        return itripHotelTempStore;
    }

    /**
     * 修改数据
     *
     * @param itripHotelTempStore 实例对象
     * @return 实例对象
     */
    @Override
    public ItripHotelTempStore update(ItripHotelTempStore itripHotelTempStore) {
        this.itripHotelTempStoreDao.update(itripHotelTempStore);
        return this.queryById(itripHotelTempStore.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.itripHotelTempStoreDao.deleteById(id) > 0;
    }
}