package com.atpco.monitor.webservice;

import com.atpco.monitor.exception.EnumRespMsg;
import com.atpco.monitor.exception.MonitorException;
import com.atpco.monitor.mapper.TaxMapper;
import com.atpco.monitor.model.Itinerary;
import com.atpco.monitor.model.QueryCondition;
import com.atpco.monitor.model.Tax;
import org.springframework.beans.factory.annotation.Autowired;

import javax.jws.WebService;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;

/**
 * Created by T440 on 2019/2/28.
 */
@WebService(endpointInterface = "com.atpco.monitor.webservice.TaxMonitor", serviceName = "TaxMonitorQuery")
public class TaxMonitorImpl implements TaxMonitor {

    @Autowired
    private TaxMapper taxMapper;

    private static final DecimalFormat DF = new DecimalFormat("#0.00");

    @Override
    public Itinerary query(Itinerary itinerary) throws MonitorException {
        if (!itinerary.check()) {
            throw new MonitorException(EnumRespMsg.CHECK_REQUEST_PARAMETERS);
        }
        try {
            QueryCondition queryCondition = new QueryCondition();
            HashMap hashMap = queryCondition.build(itinerary);
            taxMapper.queryTax(hashMap);
            int returnLabel = Integer.parseInt(hashMap.get("return_label").toString());

            switch (returnLabel) {
                case 1:
                    break;
                case -1:
                    throw new MonitorException(EnumRespMsg.CHECK_AIRPORT_INFORMATION);
                case -2:
                    throw new MonitorException(EnumRespMsg.COMPUTING_YQ_EXCEPTION);
                default:
                    throw new MonitorException(EnumRespMsg.COMPUTING_EXCEPTION);
            }

            Object routing_yq_amount = hashMap.get("routing_yq_amount");
            BigDecimal yq = BigDecimal.ZERO;
            if (routing_yq_amount != null) {
                yq = new BigDecimal(DF.format(routing_yq_amount));
            }

            BigDecimal yr = BigDecimal.ZERO;
            Object routing_yr_amount = hashMap.get("routing_yr_amount");
            if (routing_yr_amount != null) {
                yr = new BigDecimal(DF.format(routing_yr_amount));
            }

            itinerary.setYqyrAmount(yq.add(yr).doubleValue());

            BigDecimal taxAmount = BigDecimal.ZERO;
            try {
                List<Tax> list = (List<Tax>) hashMap.get("result_recs");
                if (list != null) {
                    for (int i = 0, len = list.size(); i < len; i++) {
                        if (list.get(i) != null) {
                            BigDecimal amt = new BigDecimal(list.get(i).getTax_amount());
                            taxAmount = taxAmount.add(amt);
                        }
                    }
                    itinerary.setTaxes(list);
                }
                itinerary.setTaxAmount(taxAmount.doubleValue());
            }catch (Exception e) {
                itinerary.setTaxAmount(0);
            }
            itinerary.setReturnCode("01001");
            itinerary.setReturnMsg("Result success");
        } catch (Exception e) {
            throw new MonitorException(EnumRespMsg.COMPUTING_EXCEPTION);
        }
        return itinerary;
    }
}
