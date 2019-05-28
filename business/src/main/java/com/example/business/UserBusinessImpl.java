package com.example.business;

import com.example.business.models.UserS;
import com.example.business.parameters.UserParams;
import com.example.shared.exceptions.CeibaException;

import java.util.List;

import javax.inject.Inject;

import callback.UseCaseCallBk;

public class UserBusinessImpl implements UserBusiness {

    private UserRepository mUserRepository;

    @Inject
    public UserBusinessImpl(UserRepository mUserRepository) {
        this.mUserRepository = mUserRepository;
    }

    @Override
    public void getUsersAsList(UserParams param, UseCaseCallBk.UseCaseCallback<List<UserS>> callback) {

        try {
            List<UserS> users = mUserRepository.getUsers();
            callback.onSuccess(users);

        } catch (Exception e) {
            if (e instanceof CeibaException) {
                callback.onError((CeibaException) e);
            } else {
                callback.onError(null);
            }
        }
    }
}
