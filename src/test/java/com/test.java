package com;

import com.atpco.monitor.mapper.TaxMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;

/**
 * Created by ydc on 2019/10/14.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class test {
    @Autowired
    TaxMapper taxMapper;

    @Test
    public void test1() {
        HashMap hashMap = new HashMap();

        hashMap.put("routing","PEK-SPN");
//        hashMap.put("turnaround_no", 1);
        hashMap.put("booking_date","2019-10-13");
        hashMap.put("marketing_carrier","MU");
        hashMap.put("operating_carrier","MU");
        hashMap.put("flights", "");
        hashMap.put("plane_types", "");
        hashMap.put("sale_organization","MU");
        hashMap.put("clazz","Y");
        hashMap.put("passenger_type", "ADT");
        hashMap.put("passenger_age", 20);
        hashMap.put("passenger_identity", "N");
        hashMap.put("passenger_region_type","N");
        hashMap.put("passenger_region","CN");
        hashMap.put("sale_point", "CN");
        hashMap.put("ticket_point", "CN");
        hashMap.put("sale_currency", "CNY");
        hashMap.put("fare_base","");
        hashMap.put("fare_amount",0);
        hashMap.put("ob_fee",0);
        hashMap.put("services_flight_related_fee",0);
        hashMap.put("services_ticket_related_fee",0);
        hashMap.put("services_merchandise_fee", 0);
        hashMap.put("services_oc_fee", 0);
        hashMap.put("baggage_charges", 0);
        hashMap.put("od_fee", 0);
        hashMap.put("departure_date","2019-10-13 00:00");
        hashMap.put("arrival_date","2019-10-13 02:00");
        hashMap.put("routing_yq_amount", 0);
        hashMap.put("routing_yr_amount", 0);

        taxMapper.queryTax(hashMap);

        Object routing_yq_amount = hashMap.get("routing_yq_amount");
        System.out.println(routing_yq_amount.toString());
    }

}
