package com.itrip.vo;

import io.swagger.annotations.ApiModel;

import java.util.List;

/**
 * 返回前端-酒店详情页视频文字描述（酒店特色、商圈、酒店名称）VO
 * Created by hanlu on 2017/5/24.
 */
@ApiModel(value = "HotelVideoDescVO",description = "酒店特色、商圈、酒店名称（视频文字描述）")

public class HotelVideoDescVO {

    private String hotelname;   //酒店名称

    private List<String> tradingareanameList; //酒店所属商圈

    private List<String> hotelfeaturelist; //酒店特色

    public String getHotelname() {
        return hotelname;
    }

    public void setHotelname(String hotelname) {
        this.hotelname = hotelname;
    }

    public List<String> getTradingareanameList() {
        return tradingareanameList;
    }

    public void setTradingareanameList(List<String> tradingareanameList) {
        this.tradingareanameList = tradingareanameList;
    }

    public List<String> getHotelfeaturelist() {
        return hotelfeaturelist;
    }

    public void setHotelfeaturelist(List<String> hotelfeaturelist) {
        this.hotelfeaturelist = hotelfeaturelist;
    }
}
