package com.itrip.dao;

import com.itrip.entity.ItripHotelRoom;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 酒店房间表(ItripHotelRoom)表数据库访问层
 *
 * @author zgy
 * @since 2020-03-31 15:22:05
 */
public interface ItripHotelRoomDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    ItripHotelRoom queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<ItripHotelRoom> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param itripHotelRoom 实例对象
     * @return 对象列表
     */
    List<ItripHotelRoom> queryAll(ItripHotelRoom itripHotelRoom);

    /**
     * 新增数据
     *
     * @param itripHotelRoom 实例对象
     * @return 影响行数
     */
    int insert(ItripHotelRoom itripHotelRoom);

    /**
     * 修改数据
     *
     * @param itripHotelRoom 实例对象
     * @return 影响行数
     */
    int update(ItripHotelRoom itripHotelRoom);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}