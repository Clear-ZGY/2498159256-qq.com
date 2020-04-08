package com.itrip.service;

import com.itrip.entity.ItripTradeEnds;
import java.util.List;

/**
 * 订单支付完成后，系统需对该订单进行后续处理，如减库存等。处理完成后，删除此表中的订单记录(ItripTradeEnds)表服务接口
 *
 * @author zgy
 * @since 2020-03-31 15:46:29
 */
public interface ItripTradeEndsService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    ItripTradeEnds queryById(Long id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<ItripTradeEnds> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param itripTradeEnds 实例对象
     * @return 实例对象
     */
    ItripTradeEnds insert(ItripTradeEnds itripTradeEnds);

    /**
     * 修改数据
     *
     * @param itripTradeEnds 实例对象
     * @return 实例对象
     */
    ItripTradeEnds update(ItripTradeEnds itripTradeEnds);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}