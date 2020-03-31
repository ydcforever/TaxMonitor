package com.atpco.monitor.model;

import com.atpco.monitor.exception.MonitorException;
import org.apache.commons.lang3.StringUtils;
import java.util.HashMap;

/**
 * Created by ydc on 2019/5/17.
 */
public class QueryCondition {
    public HashMap build(Itinerary itinerary) throws MonitorException{
        HashMap hashMap = new HashMap();
        String travelDate = itinerary.getTravelDate();
        String departures = "";
        String marketingCxrCodes = itinerary.getMktCxr() + ";";
        String routing = itinerary.getOrig() + "-" + itinerary.getDest()+ ";";
        String cabins = itinerary.getCabin() + ";";
        if (!StringUtils.isBlank(travelDate)) {
            departures = travelDate + " 00:00;";
        }
        if ("RT".equals(itinerary.getWayType())) {
            routing = routing +  itinerary.getDest() + "-" + itinerary.getOrig()+ ";";
            cabins = cabins + itinerary.getCabin() + ";";
            marketingCxrCodes = marketingCxrCodes + itinerary.getMktCxr() + ";";
            if (!StringUtils.isBlank(travelDate)) {
                departures += travelDate + " 10:00;";
            }
        }
        String operatingCxrCodes = marketingCxrCodes;

        int age = 20;
        if ("INF".equals(itinerary.getPaxType())) {
            age = 1;
        } else if ("CHD".equals(itinerary.getPaxType())) {
            age = 10;
        }

        hashMap.put("routing",routing);
        hashMap.put("turnaround_no", 1);
        hashMap.put("booking_date",itinerary.getSaleDate());
        hashMap.put("marketing_carrier",marketingCxrCodes);
        hashMap.put("operating_carrier",operatingCxrCodes);
//        if (!StringUtils.isBlank(flights)) {
//            hashMap.put("flights", flights.substring(1));
//        }
//        if (!StringUtils.isBlank(planeTypes)) {
//            hashMap.put("plane_types", planeTypes.substring(1));
//        }
        hashMap.put("sale_organization",itinerary.getMktCxr());
        hashMap.put("clazz",cabins);
        hashMap.put("passenger_type",itinerary.getPaxType());
        hashMap.put("passenger_age", age);
//        hashMap.put("passenger_identity",itinerary.getPassenger().getPassengerIdentity());
//        hashMap.put("passenger_region_type",itinerary.getPassenger().getPassengerRegionType());
//        hashMap.put("passenger_region",itinerary.getPassenger().getPassengerRegion());
        hashMap.put("sale_point", "CN");
        hashMap.put("ticket_point", "CN");
        hashMap.put("sale_currency",itinerary.getSaleCurrency());
        hashMap.put("fare_base","");
        hashMap.put("fare_amount",0);
        hashMap.put("ob_fee",0);
        hashMap.put("services_flight_related_fee",0);
        hashMap.put("services_ticket_related_fee",0);
        hashMap.put("services_merchandise_fee", 0);
        hashMap.put("services_oc_fee", 0);
        hashMap.put("baggage_charges", 0);
        hashMap.put("od_fee", 0);
        hashMap.put("departure_date",departures);
        hashMap.put("arrival_date","");
        hashMap.put("routing_yq_amount", 0);
        hashMap.put("routing_yr_amount", 0);
        return hashMap;
    }
}
