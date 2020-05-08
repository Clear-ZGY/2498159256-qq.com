package com.itrip.vo;

/**
 * 返回前端-图片对象VO
 * Created by hanlu on 2017/5/10.
 */
public class ItripImageVO {

    private Integer position;//页面图片展现顺序
    private String imgurl;//图片的URL访问路径

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }




}
