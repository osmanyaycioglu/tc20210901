package com.training.spring.rest.error;

import java.util.ArrayList;
import java.util.List;

public class ErrorObj {

    private List<ErrorObj> subErrors;
    private String         msg;
    private int            cause;

    public ErrorObj addSubError(final ErrorObj errorObjParam) {
        if (this.subErrors == null) {
            this.subErrors = new ArrayList<>();
        }
        this.subErrors.add(errorObjParam);
        return this;
    }

    public List<ErrorObj> getSubErrors() {
        return this.subErrors;
    }

    public void setSubErrors(final List<ErrorObj> subErrorsParam) {
        this.subErrors = subErrorsParam;
    }

    public String getMsg() {
        return this.msg;
    }

    public ErrorObj setMsg(final String msgParam) {
        this.msg = msgParam;
        return this;
    }

    public int getCause() {
        return this.cause;
    }

    public ErrorObj setCause(final int causeParam) {
        this.cause = causeParam;
        return this;
    }


}
