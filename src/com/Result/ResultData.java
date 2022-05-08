package com.Result;

public class ResultData {
    //响应码
    private int status;
    private String message;
    private Object data;

    public void setStatus(int status) {
        this.status = status;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public Object getData() {
        return data;
    }

    @Override
    public String toString() {
        return "ResultData [status=" + status + ", message=" + message + ", data=" + data + "]";
    }
}

