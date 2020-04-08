package com.itrip.service;

import com.itrip.entity.ItripHotKeyword;
import java.util.List;

/**
 * (ItripHotKeyword)表服务接口
 *
 * @author zgy
 * @since 2020-03-31 15:46:28
 */
public interface ItripHotKeywordService {

    /**
     * 通过ID查询单条数据
     *
     * @param keyword 主键
     * @return 实例对象
     */
    ItripHotKeyword queryById(String keyword);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<ItripHotKeyword> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param itripHotKeyword 实例对象
     * @return 实例对象
     */
    ItripHotKeyword insert(ItripHotKeyword itripHotKeyword);

    /**
     * 修改数据
     *
     * @param itripHotKeyword 实例对象
     * @return 实例对象
     */
    ItripHotKeyword update(ItripHotKeyword itripHotKeyword);

    /**
     * 通过主键删除数据
     *
     * @param keyword 主键
     * @return 是否成功
     */
    boolean deleteById(String keyword);

}