package com.ssm.meeting.common;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * ajax返回json数据模板
 * @author ccoder.cc
 * @since 2019/1/25 11:34
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ServerResponse {
    private String code;
    private String msg;
    private Object data;

    public ServerResponse() {
    }

    public ServerResponse(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ServerResponse(String code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
