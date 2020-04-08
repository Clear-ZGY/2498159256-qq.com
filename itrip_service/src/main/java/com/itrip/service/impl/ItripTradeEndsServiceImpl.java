package com.itrip.service.impl;

import com.itrip.entity.ItripTradeEnds;
import com.itrip.dao.ItripTradeEndsDao;
import com.itrip.service.ItripTradeEndsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 订单支付完成后，系统需对该订单进行后续处理，如减库存等。处理完成后，删除此表中的订单记录(ItripTradeEnds)表服务实现类
 *
 * @author zgy
 * @since 2020-03-31 15:46:29
 */
@Service("itripTradeEndsService")
public class ItripTradeEndsServiceImpl implements ItripTradeEndsService {
    @Resource
    private ItripTradeEndsDao itripTradeEndsDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public ItripTradeEnds queryById(Long id) {
        return this.itripTradeEndsDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<ItripTradeEnds> queryAllByLimit(int offset, int limit) {
        return this.itripTradeEndsDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param itripTradeEnds 实例对象
     * @return 实例对象
     */
    @Override
    public ItripTradeEnds insert(ItripTradeEnds itripTradeEnds) {
        this.itripTradeEndsDao.insert(itripTradeEnds);
        return itripTradeEnds;
    }

    /**
     * 修改数据
     *
     * @param itripTradeEnds 实例对象
     * @return 实例对象
     */
    @Override
    public ItripTradeEnds update(ItripTradeEnds itripTradeEnds) {
        this.itripTradeEndsDao.update(itripTradeEnds);
        return this.queryById(itripTradeEnds.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.itripTradeEndsDao.deleteById(id) > 0;
    }
}