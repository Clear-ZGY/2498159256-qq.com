package com.itrip.service.impl;

import com.itrip.entity.ItripHotel;
import com.itrip.dao.ItripHotelDao;
import com.itrip.service.ItripHotelService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 酒店表(ItripHotel)表服务实现类
 *
 * @author zgy
 * @since 2020-03-31 15:46:29
 */
@Service("itripHotelService")
public class ItripHotelServiceImpl implements ItripHotelService {
    @Resource
    private ItripHotelDao itripHotelDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public ItripHotel queryById(Long id) {
        return this.itripHotelDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<ItripHotel> queryAllByLimit(int offset, int limit) {
        return this.itripHotelDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param itripHotel 实例对象
     * @return 实例对象
     */
    @Override
    public ItripHotel insert(ItripHotel itripHotel) {
        this.itripHotelDao.insert(itripHotel);
        return itripHotel;
    }

    /**
     * 修改数据
     *
     * @param itripHotel 实例对象
     * @return 实例对象
     */
    @Override
    public ItripHotel update(ItripHotel itripHotel) {
        this.itripHotelDao.update(itripHotel);
        return this.queryById(itripHotel.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.itripHotelDao.deleteById(id) > 0;
    }
}