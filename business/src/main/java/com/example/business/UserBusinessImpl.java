package com.example.business;

import com.example.business.models.Post;
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

    @Override
    public void getUsersByName(UserParams userParams, UseCaseCallBk.UseCaseCallback<List<UserS>> callback) {
        try {
            List<UserS> users = mUserRepository.getUsersByName(userParams.getName());
            callback.onSuccess(users);

        } catch (Exception e) {
            if (e instanceof CeibaException) {
                callback.onError((CeibaException) e);
            } else {
                callback.onError(null);
            }
        }
    }

    @Override
    public void findUser(UserParams userParams, UseCaseCallBk.UseCaseCallback<UserS> callback) {
        try {
            UserS user = mUserRepository.findUserById(userParams.getId());
            callback.onSuccess(user);

        } catch (Exception e) {
            if (e instanceof CeibaException) {
                callback.onError((CeibaException) e);
            } else {
                callback.onError(null);
            }
        }
    }

    @Override
    public void findUserPosts(UserParams userParams, UseCaseCallBk.UseCaseCallback<List<Post>> callback) {
        try {
            List<Post> posts = mUserRepository.findUserPosts(userParams.getId());
            callback.onSuccess(posts);

        } catch (Exception e) {
            if (e instanceof CeibaException) {
                callback.onError((CeibaException) e);
            } else {
                callback.onError(null);
            }
        }
    }
}
