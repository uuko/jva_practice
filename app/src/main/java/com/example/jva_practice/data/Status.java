package com.example.jva_practice.data;

public class Status<T> {
    public T data;
    public StatusType status;
    public String msg;

    public Status() {
        this.status = StatusType.INIT;
    }

    public Status(StatusType status, T data, String msg) {
        this.data = data;
        this.status = status;
        this.msg = msg;
    }

    public enum StatusType {
        INIT, SUCCESS, ERROR
    }

    public Status<T> success(T data) {
        return new Status(StatusType.SUCCESS, data, "");
    }

    public Status<T> error(String msg) {
        return new Status(StatusType.ERROR, data, msg);
    }
}
