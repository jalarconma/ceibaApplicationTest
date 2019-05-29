package com.example.business;

import com.example.business.models.UserS;
import com.example.business.parameters.UserParams;

import java.util.List;

import callback.UseCaseCallBk;

public interface UserBusiness {

    void getUsersAsList(UserParams param, UseCaseCallBk.UseCaseCallback<List<UserS>> callback);

    void getUsersByName(UserParams userParams, UseCaseCallBk.UseCaseCallback<List<UserS>> callback);
}
