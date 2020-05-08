package com.itrip.service.impl;

import com.itrip.entity.ItripAreaDic;
import com.itrip.dao.ItripAreaDicDao;
import com.itrip.service.ItripAreaDicService;
import com.itrip.vo.ItripAreaDicVo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 区域字典表(ItripAreaDic)表服务实现类
 *
 * @author zgy
 * @since 2020-03-31 15:46:28
 */
@Service("itripAreaDicService")
public class ItripAreaDicServiceImpl implements ItripAreaDicService {
    @Resource
    private ItripAreaDicDao itripAreaDicDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public ItripAreaDic queryById(Long id) {
        return this.itripAreaDicDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<ItripAreaDic> queryAllByLimit(int offset, int limit) {
        return this.itripAreaDicDao.queryAllByLimit(offset, limit);
    }

    /**
     * 根据parent查询商圈
     *
     * @param parent 父级区域
     * @return 对象列表
     */
    @Override
    public List<ItripAreaDic> queryByParent(int parent) {
        Integer i = parent;
        Long parentId=i.longValue();
        ItripAreaDic itripAreaDic = new ItripAreaDic();
        itripAreaDic.setParent(parentId);
        itripAreaDic.setIsactivated(1);
        itripAreaDic.setIstradingarea(1);
        return this.itripAreaDicDao.queryByParent(itripAreaDic);
    }

    /**
     * 根据type查询热门城市
     *
     * @param type 参数
     * @return 对象列表
     */
    @Override
    public List<ItripAreaDicVo> queryByType(Integer type) {
        List<ItripAreaDicVo> itripAreaDicVoList = new ArrayList<>();
        ItripAreaDicVo itripAreaDicVo = null;
        ItripAreaDic itripAreaDic = new ItripAreaDic();
        itripAreaDic.setIshot(1);
        itripAreaDic.setIschina(type);
        List<ItripAreaDic> itripAreaDics = this.itripAreaDicDao.queryAll(itripAreaDic);
        for (ItripAreaDic areadic:itripAreaDics) {
            itripAreaDicVo = new ItripAreaDicVo();
            BeanUtils.copyProperties(areadic,itripAreaDicVo);
            itripAreaDicVoList.add(itripAreaDicVo);
        }

        return itripAreaDicVoList;
    }

    /**
     * 新增数据
     *
     * @param itripAreaDic 实例对象
     * @return 实例对象
     */
    @Override
    public ItripAreaDic insert(ItripAreaDic itripAreaDic) {
        this.itripAreaDicDao.insert(itripAreaDic);
        return itripAreaDic;
    }

    /**
     * 修改数据
     *
     * @param itripAreaDic 实例对象
     * @return 实例对象
     */
    @Override
    public ItripAreaDic update(ItripAreaDic itripAreaDic) {
        this.itripAreaDicDao.update(itripAreaDic);
        return this.queryById(itripAreaDic.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.itripAreaDicDao.deleteById(id) > 0;
    }
}