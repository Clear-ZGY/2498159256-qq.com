package com.itrip.entity;

import java.io.Serializable;

/**
 * (ItripHotKeyword)实体类
 *
 * @author zgy
 * @since 2020-03-31 15:18:58
 */
public class ItripHotKeyword implements Serializable {
    private static final long serialVersionUID = 462432385894758897L;
    
    private String keyword;
    
    private Integer rank;

        
    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
        
    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

}