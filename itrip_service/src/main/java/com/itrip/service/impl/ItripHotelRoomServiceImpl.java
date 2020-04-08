package com.itrip.service.impl;

import com.itrip.entity.ItripHotelRoom;
import com.itrip.dao.ItripHotelRoomDao;
import com.itrip.service.ItripHotelRoomService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 酒店房间表(ItripHotelRoom)表服务实现类
 *
 * @author zgy
 * @since 2020-03-31 15:46:28
 */
@Service("itripHotelRoomService")
public class ItripHotelRoomServiceImpl implements ItripHotelRoomService {
    @Resource
    private ItripHotelRoomDao itripHotelRoomDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public ItripHotelRoom queryById(Long id) {
        return this.itripHotelRoomDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<ItripHotelRoom> queryAllByLimit(int offset, int limit) {
        return this.itripHotelRoomDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param itripHotelRoom 实例对象
     * @return 实例对象
     */
    @Override
    public ItripHotelRoom insert(ItripHotelRoom itripHotelRoom) {
        this.itripHotelRoomDao.insert(itripHotelRoom);
        return itripHotelRoom;
    }

    /**
     * 修改数据
     *
     * @param itripHotelRoom 实例对象
     * @return 实例对象
     */
    @Override
    public ItripHotelRoom update(ItripHotelRoom itripHotelRoom) {
        this.itripHotelRoomDao.update(itripHotelRoom);
        return this.queryById(itripHotelRoom.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.itripHotelRoomDao.deleteById(id) > 0;
    }
}