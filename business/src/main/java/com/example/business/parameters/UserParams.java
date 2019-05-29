package com.example.business.parameters;

import com.example.business.IParameter;

public class UserParams implements IParameter {

    public UserParams(Integer id, String name) {
        this.name = name;
    }

    private Integer id;

    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
