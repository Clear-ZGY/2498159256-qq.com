package com.itrip.service.impl;

import com.itrip.entity.ItripHotelFeature;
import com.itrip.dao.ItripHotelFeatureDao;
import com.itrip.service.ItripHotelFeatureService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (ItripHotelFeature)表服务实现类
 *
 * @author zgy
 * @since 2020-03-31 15:46:29
 */
@Service("itripHotelFeatureService")
public class ItripHotelFeatureServiceImpl implements ItripHotelFeatureService {
    @Resource
    private ItripHotelFeatureDao itripHotelFeatureDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public ItripHotelFeature queryById(Long id) {
        return this.itripHotelFeatureDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<ItripHotelFeature> queryAllByLimit(int offset, int limit) {
        return this.itripHotelFeatureDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param itripHotelFeature 实例对象
     * @return 实例对象
     */
    @Override
    public ItripHotelFeature insert(ItripHotelFeature itripHotelFeature) {
        this.itripHotelFeatureDao.insert(itripHotelFeature);
        return itripHotelFeature;
    }

    /**
     * 修改数据
     *
     * @param itripHotelFeature 实例对象
     * @return 实例对象
     */
    @Override
    public ItripHotelFeature update(ItripHotelFeature itripHotelFeature) {
        this.itripHotelFeatureDao.update(itripHotelFeature);
        return this.queryById(itripHotelFeature.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.itripHotelFeatureDao.deleteById(id) > 0;
    }
}