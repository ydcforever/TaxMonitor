package com.atpco.monitor.mapper;

import com.atpco.monitor.exception.MonitorException;

import java.util.HashMap;

/**
 * Created by ydc on 2019/5/17.
 */
public interface TaxMapper {
    public void queryTax(HashMap map) throws MonitorException;
}
