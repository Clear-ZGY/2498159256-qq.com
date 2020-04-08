package com.itrip.service;

import com.itrip.entity.ItripComment;
import java.util.List;

/**
 * 评论表(ItripComment)表服务接口
 *
 * @author zgy
 * @since 2020-03-31 15:46:28
 */
public interface ItripCommentService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    ItripComment queryById(Long id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<ItripComment> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param itripComment 实例对象
     * @return 实例对象
     */
    ItripComment insert(ItripComment itripComment);

    /**
     * 修改数据
     *
     * @param itripComment 实例对象
     * @return 实例对象
     */
    ItripComment update(ItripComment itripComment);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}