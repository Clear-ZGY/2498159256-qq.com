package com.itrip.service.impl;

import com.itrip.entity.ItripHotelTradingArea;
import com.itrip.dao.ItripHotelTradingAreaDao;
import com.itrip.service.ItripHotelTradingAreaService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (ItripHotelTradingArea)表服务实现类
 *
 * @author zgy
 * @since 2020-03-31 15:46:28
 */
@Service("itripHotelTradingAreaService")
public class ItripHotelTradingAreaServiceImpl implements ItripHotelTradingAreaService {
    @Resource
    private ItripHotelTradingAreaDao itripHotelTradingAreaDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public ItripHotelTradingArea queryById(Long id) {
        return this.itripHotelTradingAreaDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<ItripHotelTradingArea> queryAllByLimit(int offset, int limit) {
        return this.itripHotelTradingAreaDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param itripHotelTradingArea 实例对象
     * @return 实例对象
     */
    @Override
    public ItripHotelTradingArea insert(ItripHotelTradingArea itripHotelTradingArea) {
        this.itripHotelTradingAreaDao.insert(itripHotelTradingArea);
        return itripHotelTradingArea;
    }

    /**
     * 修改数据
     *
     * @param itripHotelTradingArea 实例对象
     * @return 实例对象
     */
    @Override
    public ItripHotelTradingArea update(ItripHotelTradingArea itripHotelTradingArea) {
        this.itripHotelTradingAreaDao.update(itripHotelTradingArea);
        return this.queryById(itripHotelTradingArea.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.itripHotelTradingAreaDao.deleteById(id) > 0;
    }
}