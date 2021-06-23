package com.khmoon.recyclerview_swipe3.DB;

public class DB_checkserver {
    private int id;
    private String country;

    public DB_checkserver(String country) {
        this.country = country;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
