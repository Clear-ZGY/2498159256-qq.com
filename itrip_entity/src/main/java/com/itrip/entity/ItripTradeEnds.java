package com.itrip.entity;

import java.io.Serializable;

/**
 * 订单支付完成后，系统需对该订单进行后续处理，如减库存等。处理完成后，删除此表中的订单记录(ItripTradeEnds)实体类
 *
 * @author zgy
 * @since 2020-03-31 15:18:58
 */
public class ItripTradeEnds implements Serializable {
    private static final long serialVersionUID = -17925460309346659L;
    /**
    * 订单ID
    */
    private Long id;
    /**
    * 订单编号(注意非支付宝交易编号tradeNo)
    */
    private String orderno;
    /**
    * 标识字段(默认0：未处理；1：处理中)
    */
    private Object flag;

        
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
        
    public String getOrderno() {
        return orderno;
    }

    public void setOrderno(String orderno) {
        this.orderno = orderno;
    }
        
    public Object getFlag() {
        return flag;
    }

    public void setFlag(Object flag) {
        this.flag = flag;
    }

}