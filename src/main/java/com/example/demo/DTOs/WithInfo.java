package com.example.demo.DTOs;

public class WithInfo<T> {
    String info;
    T data;

    public String getInfo () {
        return info;
    }

    public void setInfo (String info) {
        this.info = info;
    }

    public T getData () {
        return data;
    }

    public void setData (T data) {
        this.data = data;
    }
}
