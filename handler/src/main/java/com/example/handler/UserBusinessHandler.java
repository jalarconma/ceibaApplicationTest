package com.example.handler;

import com.example.business.UserBusiness;
import com.example.business.UserBusinessImpl;
import com.example.business.executor.PostExecutionThread;
import com.example.business.executor.ThreadExecutor;
import com.example.business.models.Post;
import com.example.business.models.UserS;
import com.example.business.parameters.UserParams;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import callback.UseCaseCallBk;

@Singleton
public class UserBusinessHandler extends BusinessHandler implements UserBusiness {

    private UserBusinessImpl mUserBusiness;

    @Inject
    public UserBusinessHandler(ThreadExecutor mThreadExecutor,
                               PostExecutionThread mPostExecutionThread,
                               UserBusinessImpl mUserBusiness) {
        super(mThreadExecutor, mPostExecutionThread);
        this.mUserBusiness = mUserBusiness;
    }

    @Override
    public void getUsersAsList(UserParams param, UseCaseCallBk.UseCaseCallback<List<UserS>> callback) {
        execute((p, c) -> mUserBusiness.getUsersAsList(p, c), param, callback);
    }

    @Override
    public void getUsersByName(UserParams param, UseCaseCallBk.UseCaseCallback<List<UserS>> callback) {
        execute((p, c) -> mUserBusiness.getUsersByName(p, c), param, callback);
    }

    @Override
    public void findUser(UserParams param, UseCaseCallBk.UseCaseCallback<UserS> callback) {
        execute((p, c) -> mUserBusiness.findUser(p, c), param, callback);
    }

    @Override
    public void findUserPosts(UserParams param, UseCaseCallBk.UseCaseCallback<List<Post>> callback) {
        execute((p, c) -> mUserBusiness.findUserPosts(p, c), param, callback);
    }
}
