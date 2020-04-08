package com.itrip.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (ItripHotelExtendProperty)实体类
 *
 * @author zgy
 * @since 2020-03-31 15:18:58
 */
public class ItripHotelExtendProperty implements Serializable {
    private static final long serialVersionUID = 183197047770772965L;
    
    private Long id;
    /**
    * 酒店id
    */
    private Long hotelid;
    /**
    * 推广属性
    */
    private Long extendpropertyid;
    
    private Date creationdate;
    
    private Long createdby;
    
    private Date modifydate;
    
    private Long modifiedby;

        
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
        
    public Long getHotelid() {
        return hotelid;
    }

    public void setHotelid(Long hotelid) {
        this.hotelid = hotelid;
    }
        
    public Long getExtendpropertyid() {
        return extendpropertyid;
    }

    public void setExtendpropertyid(Long extendpropertyid) {
        this.extendpropertyid = extendpropertyid;
    }
        
    public Date getCreationdate() {
        return creationdate;
    }

    public void setCreationdate(Date creationdate) {
        this.creationdate = creationdate;
    }
        
    public Long getCreatedby() {
        return createdby;
    }

    public void setCreatedby(Long createdby) {
        this.createdby = createdby;
    }
        
    public Date getModifydate() {
        return modifydate;
    }

    public void setModifydate(Date modifydate) {
        this.modifydate = modifydate;
    }
        
    public Long getModifiedby() {
        return modifiedby;
    }

    public void setModifiedby(Long modifiedby) {
        this.modifiedby = modifiedby;
    }

}