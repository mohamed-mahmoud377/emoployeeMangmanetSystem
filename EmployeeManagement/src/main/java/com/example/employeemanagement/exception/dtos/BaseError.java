package com.example.employeemanagement.exception.dtos;


import lombok.Getter;
import lombok.ToString;
import org.apache.commons.lang3.time.FastDateFormat;

@Getter
@ToString
public class BaseError {

    private static final FastDateFormat DATE_FORMAT = FastDateFormat.getInstance("yyyy-MM-dd HH:mm:ss.SSS");
    private final boolean status;
    private final String timestamp;
    private final BaseErrorCode<?> errorCode;
    private final String messageAr;
    private final String messageEn;
    private final Object detail;

    public BaseError(BaseErrorCode<?> errorCode, String messageAr, String messageEn, Object detail) {
        this.status = false;
        this.timestamp = DATE_FORMAT.format(System.currentTimeMillis());
        this.errorCode = errorCode;
        this.messageAr = messageAr;
        this.messageEn = messageEn;
        this.detail = detail;
    }

}
