package com.atpco.monitor.model;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ydc on 2019/10/14.
 */
public class Itinerary {
    /**
     * 市场方 必传
     */
    private String mktCxr;

    /*
     * 起始地 必传
     */
    private String orig;

    /*
     * 目的地 必传
     */
    private String dest;

    /*
     * 航线类型（OW/RT）必传
     * 航线仅支持orig-dest和orig-dest;dest-orig两种，中间不含中转
     */
    private String wayType;

    /*
     * 销售日期
     */
    private String saleDate;

    /*
     * 旅行日期
     */
    private String travelDate;

    /*
     * 乘客类型
     */
    private String paxType;

    /*
     * 大舱位
     * 仅支持所有航段一致舱等
     */
    private String cabin;

    /*
     * 销售货币
     */
    private String saleCurrency;

    /*
     * 燃油费总值
     */
    private double yqyrAmount;

    /*
     * 机场税总值
     */
    private double taxAmount;

    /**
     * 税费明细
     */
    private List<Tax> taxes;

    /**
     * 返回码
     */
    private String returnCode;

    /**
     * 返回说明
     */
    private String returnMsg;

    public String getMktCxr() {
        return mktCxr;
    }

    public void setMktCxr(String mktCxr) {
        this.mktCxr = mktCxr;
    }

    public String getOrig() {
        return orig;
    }

    public void setOrig(String orig) {
        this.orig = orig;
    }

    public String getDest() {
        return dest;
    }

    public void setDest(String dest) {
        this.dest = dest;
    }

    public String getWayType() {
        return wayType;
    }

    public void setWayType(String wayType) {
        this.wayType = wayType;
    }

    public String getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(String saleDate) {
        this.saleDate = saleDate;
    }

    public String getTravelDate() {
        return travelDate;
    }

    public void setTravelDate(String travelDate) {
        this.travelDate = travelDate;
    }

    public String getPaxType() {
        return paxType;
    }

    public void setPaxType(String paxType) {
        this.paxType = paxType;
    }

    public String getCabin() {
        return cabin;
    }

    public void setCabin(String cabin) {
        this.cabin = cabin;
    }

    public String getSaleCurrency() {
        return saleCurrency;
    }

    public void setSaleCurrency(String saleCurrency) {
        this.saleCurrency = saleCurrency;
    }

    public double getYqyrAmount() {
        return yqyrAmount;
    }

    public void setYqyrAmount(double yqyrAmount) {
        this.yqyrAmount = yqyrAmount;
    }

    public double getTaxAmount() {
        return taxAmount;
    }

    public void setTaxAmount(double taxAmount) {
        this.taxAmount = taxAmount;
    }

    public String getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(String returnCode) {
        this.returnCode = returnCode;
    }

    public String getReturnMsg() {
        return returnMsg;
    }

    public void setReturnMsg(String returnMsg) {
        this.returnMsg = returnMsg;
    }

    public List<Tax> getTaxes() {
        return taxes;
    }

    public void setTaxes(List<Tax> taxes) {
        this.taxes = new ArrayList<Tax>();
        this.taxes.addAll(taxes);
    }

    public boolean check() {
        if (StringUtils.isBlank(mktCxr) || StringUtils.isBlank(orig) || StringUtils.isBlank(dest) ||
                (!"RT".equals(wayType) && !"OW".equals(wayType))) {
            return false;
        }
        if (StringUtils.isBlank(cabin)) {
            this.cabin = "Y";
        }
        if (StringUtils.isBlank(saleCurrency)) {
            this.saleCurrency = "CNY";
        }
        if (StringUtils.isBlank(paxType)) {
            this.paxType = "ADT";
        }
        this.taxes = new ArrayList<Tax>();
        return true;
    }
}
