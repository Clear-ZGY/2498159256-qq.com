package com.itrip.service.impl;

import com.itrip.entity.ItripHotKeyword;
import com.itrip.dao.ItripHotKeywordDao;
import com.itrip.service.ItripHotKeywordService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (ItripHotKeyword)表服务实现类
 *
 * @author zgy
 * @since 2020-03-31 15:46:28
 */
@Service("itripHotKeywordService")
public class ItripHotKeywordServiceImpl implements ItripHotKeywordService {
    @Resource
    private ItripHotKeywordDao itripHotKeywordDao;

    /**
     * 通过ID查询单条数据
     *
     * @param keyword 主键
     * @return 实例对象
     */
    @Override
    public ItripHotKeyword queryById(String keyword) {
        return this.itripHotKeywordDao.queryById(keyword);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<ItripHotKeyword> queryAllByLimit(int offset, int limit) {
        return this.itripHotKeywordDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param itripHotKeyword 实例对象
     * @return 实例对象
     */
    @Override
    public ItripHotKeyword insert(ItripHotKeyword itripHotKeyword) {
        this.itripHotKeywordDao.insert(itripHotKeyword);
        return itripHotKeyword;
    }

    /**
     * 修改数据
     *
     * @param itripHotKeyword 实例对象
     * @return 实例对象
     */
    @Override
    public ItripHotKeyword update(ItripHotKeyword itripHotKeyword) {
        this.itripHotKeywordDao.update(itripHotKeyword);
        return this.queryById(itripHotKeyword.getKeyword());
    }

    /**
     * 通过主键删除数据
     *
     * @param keyword 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String keyword) {
        return this.itripHotKeywordDao.deleteById(keyword) > 0;
    }
}