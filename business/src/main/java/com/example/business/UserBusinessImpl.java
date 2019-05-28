package com.example.business;

import com.example.business.models.UserS;
import com.example.business.parameters.UserParams;

import java.util.List;

import javax.inject.Inject;

import callback.UseCaseCallBk;

public class UserBusinessImpl implements UserBusiness {

    @Inject
    public UserBusinessImpl() {
    }

    @Override
    public void getUsersAsList(UserParams param, UseCaseCallBk.UseCaseCallback<List<UserS>> callback) {

    }
}
