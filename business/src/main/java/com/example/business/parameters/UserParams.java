package com.example.business.parameters;

import com.example.business.IParameter;

public class UserParams implements IParameter {

    public UserParams(String name) {
        this.name = name;
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
