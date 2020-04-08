package com.itrip.service.impl;

import com.itrip.entity.ItripLabelDic;
import com.itrip.dao.ItripLabelDicDao;
import com.itrip.service.ItripLabelDicService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 标签字典表(ItripLabelDic)表服务实现类
 *
 * @author zgy
 * @since 2020-03-31 15:46:29
 */
@Service("itripLabelDicService")
public class ItripLabelDicServiceImpl implements ItripLabelDicService {
    @Resource
    private ItripLabelDicDao itripLabelDicDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public ItripLabelDic queryById(Long id) {
        return this.itripLabelDicDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<ItripLabelDic> queryAllByLimit(int offset, int limit) {
        return this.itripLabelDicDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param itripLabelDic 实例对象
     * @return 实例对象
     */
    @Override
    public ItripLabelDic insert(ItripLabelDic itripLabelDic) {
        this.itripLabelDicDao.insert(itripLabelDic);
        return itripLabelDic;
    }

    /**
     * 修改数据
     *
     * @param itripLabelDic 实例对象
     * @return 实例对象
     */
    @Override
    public ItripLabelDic update(ItripLabelDic itripLabelDic) {
        this.itripLabelDicDao.update(itripLabelDic);
        return this.queryById(itripLabelDic.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.itripLabelDicDao.deleteById(id) > 0;
    }
}