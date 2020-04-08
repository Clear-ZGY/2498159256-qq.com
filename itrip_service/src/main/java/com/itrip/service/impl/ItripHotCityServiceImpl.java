package com.itrip.service.impl;

import com.itrip.entity.ItripHotCity;
import com.itrip.dao.ItripHotCityDao;
import com.itrip.service.ItripHotCityService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (ItripHotCity)表服务实现类
 *
 * @author zgy
 * @since 2020-03-31 15:46:29
 */
@Service("itripHotCityService")
public class ItripHotCityServiceImpl implements ItripHotCityService {
    @Resource
    private ItripHotCityDao itripHotCityDao;

    /**
     * 通过ID查询单条数据
     *
     * @param city 主键
     * @return 实例对象
     */
    @Override
    public ItripHotCity queryById(String city) {
        return this.itripHotCityDao.queryById(city);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<ItripHotCity> queryAllByLimit(int offset, int limit) {
        return this.itripHotCityDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param itripHotCity 实例对象
     * @return 实例对象
     */
    @Override
    public ItripHotCity insert(ItripHotCity itripHotCity) {
        this.itripHotCityDao.insert(itripHotCity);
        return itripHotCity;
    }

    /**
     * 修改数据
     *
     * @param itripHotCity 实例对象
     * @return 实例对象
     */
    @Override
    public ItripHotCity update(ItripHotCity itripHotCity) {
        this.itripHotCityDao.update(itripHotCity);
        return this.queryById(itripHotCity.getCity());
    }

    /**
     * 通过主键删除数据
     *
     * @param city 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String city) {
        return this.itripHotCityDao.deleteById(city) > 0;
    }
}