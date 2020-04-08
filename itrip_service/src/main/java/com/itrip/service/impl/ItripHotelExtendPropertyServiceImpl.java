package com.itrip.service.impl;

import com.itrip.entity.ItripHotelExtendProperty;
import com.itrip.dao.ItripHotelExtendPropertyDao;
import com.itrip.service.ItripHotelExtendPropertyService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (ItripHotelExtendProperty)表服务实现类
 *
 * @author zgy
 * @since 2020-03-31 15:46:29
 */
@Service("itripHotelExtendPropertyService")
public class ItripHotelExtendPropertyServiceImpl implements ItripHotelExtendPropertyService {
    @Resource
    private ItripHotelExtendPropertyDao itripHotelExtendPropertyDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public ItripHotelExtendProperty queryById(Long id) {
        return this.itripHotelExtendPropertyDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<ItripHotelExtendProperty> queryAllByLimit(int offset, int limit) {
        return this.itripHotelExtendPropertyDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param itripHotelExtendProperty 实例对象
     * @return 实例对象
     */
    @Override
    public ItripHotelExtendProperty insert(ItripHotelExtendProperty itripHotelExtendProperty) {
        this.itripHotelExtendPropertyDao.insert(itripHotelExtendProperty);
        return itripHotelExtendProperty;
    }

    /**
     * 修改数据
     *
     * @param itripHotelExtendProperty 实例对象
     * @return 实例对象
     */
    @Override
    public ItripHotelExtendProperty update(ItripHotelExtendProperty itripHotelExtendProperty) {
        this.itripHotelExtendPropertyDao.update(itripHotelExtendProperty);
        return this.queryById(itripHotelExtendProperty.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.itripHotelExtendPropertyDao.deleteById(id) > 0;
    }
}