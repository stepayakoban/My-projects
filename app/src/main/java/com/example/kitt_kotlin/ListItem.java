package com.example.kitt_kotlin;

public class ListItem {
    private String name;
    private String flag;
    private String  isocode2,isocode3;

    public ListItem(String name, String description) {
        this.name = name;
        this.flag = description;
    }

    public String getName() {
        return name;
    }

    public String getIsocode2() {
        return isocode2;
    }

    public String getIsocode3() {
        return isocode3;
    }

    public String getFlag() {
        return flag;
    }
}

