package com.atpco.monitor.webservice;

import com.atpco.monitor.exception.MonitorException;
import com.atpco.monitor.model.Itinerary;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

/**
 * Created by T440 on 2019/2/28.
 */
@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)//用一个绑定的annotation用来说明网络协议和格式
public interface TaxMonitor {
    public Itinerary query(Itinerary itinerary) throws MonitorException;
}
