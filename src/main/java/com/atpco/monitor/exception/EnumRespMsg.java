package com.atpco.monitor.exception;

public enum EnumRespMsg {

    SUCCESS("01001", "Result success"),
    CHECK_REQUEST_PARAMETERS("02001", "Some request parameters are invalid"),
    CHECK_AIRPORT_INFORMATION("03001", "Some airports don't exist"),
    COMPUTING_YQ_EXCEPTION("04001", "YQ not found or define"),
    COMPUTING_EXCEPTION("05001", "Program exception");

    EnumRespMsg(String code, String description) {
        this.code = code;
        this.description = description;
    }

    private String code;

    private String description;

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

}
