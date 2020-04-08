package com.itrip.service.impl;

import com.itrip.entity.ItripComment;
import com.itrip.dao.ItripCommentDao;
import com.itrip.service.ItripCommentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 评论表(ItripComment)表服务实现类
 *
 * @author zgy
 * @since 2020-03-31 15:46:28
 */
@Service("itripCommentService")
public class ItripCommentServiceImpl implements ItripCommentService {
    @Resource
    private ItripCommentDao itripCommentDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public ItripComment queryById(Long id) {
        return this.itripCommentDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<ItripComment> queryAllByLimit(int offset, int limit) {
        return this.itripCommentDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param itripComment 实例对象
     * @return 实例对象
     */
    @Override
    public ItripComment insert(ItripComment itripComment) {
        this.itripCommentDao.insert(itripComment);
        return itripComment;
    }

    /**
     * 修改数据
     *
     * @param itripComment 实例对象
     * @return 实例对象
     */
    @Override
    public ItripComment update(ItripComment itripComment) {
        this.itripCommentDao.update(itripComment);
        return this.queryById(itripComment.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.itripCommentDao.deleteById(id) > 0;
    }
}