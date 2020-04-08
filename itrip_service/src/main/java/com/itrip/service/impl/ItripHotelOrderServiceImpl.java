package com.itrip.service.impl;

import com.itrip.entity.ItripHotelOrder;
import com.itrip.dao.ItripHotelOrderDao;
import com.itrip.service.ItripHotelOrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 订单表(ItripHotelOrder)表服务实现类
 *
 * @author zgy
 * @since 2020-03-31 15:46:29
 */
@Service("itripHotelOrderService")
public class ItripHotelOrderServiceImpl implements ItripHotelOrderService {
    @Resource
    private ItripHotelOrderDao itripHotelOrderDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public ItripHotelOrder queryById(Long id) {
        return this.itripHotelOrderDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<ItripHotelOrder> queryAllByLimit(int offset, int limit) {
        return this.itripHotelOrderDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param itripHotelOrder 实例对象
     * @return 实例对象
     */
    @Override
    public ItripHotelOrder insert(ItripHotelOrder itripHotelOrder) {
        this.itripHotelOrderDao.insert(itripHotelOrder);
        return itripHotelOrder;
    }

    /**
     * 修改数据
     *
     * @param itripHotelOrder 实例对象
     * @return 实例对象
     */
    @Override
    public ItripHotelOrder update(ItripHotelOrder itripHotelOrder) {
        this.itripHotelOrderDao.update(itripHotelOrder);
        return this.queryById(itripHotelOrder.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.itripHotelOrderDao.deleteById(id) > 0;
    }
}