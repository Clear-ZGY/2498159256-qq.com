package com.itrip.service.impl;

import com.itrip.entity.ItripImage;
import com.itrip.dao.ItripImageDao;
import com.itrip.service.ItripImageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 图片表(ItripImage)表服务实现类
 *
 * @author zgy
 * @since 2020-03-31 15:46:29
 */
@Service("itripImageService")
public class ItripImageServiceImpl implements ItripImageService {
    @Resource
    private ItripImageDao itripImageDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public ItripImage queryById(Long id) {
        return this.itripImageDao.queryById(id);
    }

    /**
     * 通过targetId查询数据
     *
     * @param targetId 酒店ID
     * @return 对象列表
     */

    @Override
    public List<ItripImage> queryByTargetId(Long targetId) {
        ItripImage itripImage = new ItripImage();
        itripImage.setTargetid(targetId);
        itripImage.setType("0");
        return this.itripImageDao.queryByTargetId(itripImage);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<ItripImage> queryAllByLimit(int offset, int limit) {
        return this.itripImageDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param itripImage 实例对象
     * @return 实例对象
     */
    @Override
    public ItripImage insert(ItripImage itripImage) {
        this.itripImageDao.insert(itripImage);
        return itripImage;
    }

    /**
     * 修改数据
     *
     * @param itripImage 实例对象
     * @return 实例对象
     */
    @Override
    public ItripImage update(ItripImage itripImage) {
        this.itripImageDao.update(itripImage);
        return this.queryById(itripImage.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.itripImageDao.deleteById(id) > 0;
    }
}