package io.github.yhugorocha.exception;

import java.io.Serializable;

public class StandartError implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer statusCode;
    private String errorCode;
    private String message;
    private Long timestamp;

    public StandartError() {
    }

    public StandartError(Integer statusCode, String errorCode, String message, Long timestamp) {
        this.statusCode = statusCode;
        this.errorCode = errorCode;
        this.message = message;
        this.timestamp = timestamp;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }
}
