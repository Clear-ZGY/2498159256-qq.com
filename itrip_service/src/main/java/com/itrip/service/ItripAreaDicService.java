package com.itrip.service;

import com.itrip.entity.ItripAreaDic;
import com.itrip.vo.ItripAreaDicVo;
import com.itrip.vo.ItripLabelDicVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 区域字典表(ItripAreaDic)表服务接口
 *
 * @author zgy
 * @since 2020-03-31 15:46:27
 */
public interface ItripAreaDicService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    ItripAreaDic queryById(Long id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<ItripAreaDic> queryAllByLimit(int offset, int limit);

    /**
     * 根据parent查询商圈
     *
     * @param parent 父级区域
     * @return 对象列表
     */
    List<ItripAreaDic> queryByParent(@Param("parent") int parent);

    /**
     * 根据type查询热门城市
     *
     * @param type 参数
     * @return 对象列表
     */
    List<ItripAreaDicVo> queryByType(Integer type);

    /**
     * 新增数据
     *
     * @param itripAreaDic 实例对象
     * @return 实例对象
     */
    ItripAreaDic insert(ItripAreaDic itripAreaDic);

    /**
     * 修改数据
     *
     * @param itripAreaDic 实例对象
     * @return 实例对象
     */
    ItripAreaDic update(ItripAreaDic itripAreaDic);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}