package com.itrip.entity;

import java.io.Serializable;

/**
 * (ItripHotCity)实体类
 *
 * @author zgy
 * @since 2020-03-31 15:18:58
 */
public class ItripHotCity implements Serializable {
    private static final long serialVersionUID = 247295012846526849L;
    
    private String city;
    
    private Integer rank;

        
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
        
    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

}