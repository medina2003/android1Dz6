package com.example.android1dz6;

import java.io.Serializable;

public class TheCountry implements Serializable {
    private int flag;
    private String city;
    int position;

    public TheCountry(int flag, String city, int position) {
        this.flag = flag;
        this.city = city;
        this.position = position;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
