package com.atpco.monitor.exception;

import org.apache.commons.lang3.StringUtils;

public class MonitorException extends RuntimeException {

    public String iErrCode = "";

    public String iErrMessage = "";

    public MonitorException(String aMessage) {
        super(aMessage);
        this.iErrMessage = aMessage;
    }

    public MonitorException(String aCode, String aMessage) {
        super(aMessage);
        this.iErrCode = aCode.trim();
        this.iErrMessage = aMessage;
    }

    public MonitorException(EnumRespMsg enumRespMsg) {
        this.iErrCode = enumRespMsg.getCode();
        this.iErrMessage = enumRespMsg.getDescription();
    }

    public String getCode() {
        return iErrCode;
    }

    public String getMessage() {
        return StringUtils.isBlank(super.getMessage()) ? this.iErrMessage : super.getMessage();
    }

    public String getErrMsg() {
        return StringUtils.isBlank(iErrMessage) ? super.getMessage() : iErrMessage;
    }

    public MonitorException(String aCode, String aMessage, String aDetailMessage) {
        super(aMessage.trim());
        iErrCode = aCode.trim();
        iErrMessage = aDetailMessage.trim();
    }

    public MonitorException(String iErrCode, String iErrMessage, Throwable cause) {
        super(cause);
        this.iErrCode = iErrCode.trim();
        this.iErrMessage = iErrMessage.trim();
    }

    public MonitorException(Throwable cause) {
        super(cause);
    }
}
