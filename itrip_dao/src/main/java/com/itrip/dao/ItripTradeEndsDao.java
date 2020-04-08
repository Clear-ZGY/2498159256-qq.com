package com.itrip.dao;

import com.itrip.entity.ItripTradeEnds;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 订单支付完成后，系统需对该订单进行后续处理，如减库存等。处理完成后，删除此表中的订单记录(ItripTradeEnds)表数据库访问层
 *
 * @author zgy
 * @since 2020-03-31 15:22:05
 */
public interface ItripTradeEndsDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    ItripTradeEnds queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<ItripTradeEnds> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param itripTradeEnds 实例对象
     * @return 对象列表
     */
    List<ItripTradeEnds> queryAll(ItripTradeEnds itripTradeEnds);

    /**
     * 新增数据
     *
     * @param itripTradeEnds 实例对象
     * @return 影响行数
     */
    int insert(ItripTradeEnds itripTradeEnds);

    /**
     * 修改数据
     *
     * @param itripTradeEnds 实例对象
     * @return 影响行数
     */
    int update(ItripTradeEnds itripTradeEnds);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}