package com.itrip.service;

import com.itrip.entity.ItripLabelDic;
import com.itrip.vo.ItripLabelDicVO;

import java.util.List;

/**
 * 标签字典表(ItripLabelDic)表服务接口
 *
 * @author zgy
 * @since 2020-03-31 15:46:29
 */
public interface ItripLabelDicService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    ItripLabelDic queryById(Long id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<ItripLabelDic> queryAllByLimit(int offset, int limit);

    /**
     * 根据ParentId查询多条数据
     *
     * @param parentId 参数
     * @return 对象列表
     */
    List<ItripLabelDicVO> queryByParentId(Long parentId);



    /**
     * 新增数据
     *
     * @param itripLabelDic 实例对象
     * @return 实例对象
     */
    ItripLabelDic insert(ItripLabelDic itripLabelDic);

    /**
     * 修改数据
     *
     * @param itripLabelDic 实例对象
     * @return 实例对象
     */
    ItripLabelDic update(ItripLabelDic itripLabelDic);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}