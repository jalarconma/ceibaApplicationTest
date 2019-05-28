package com.example.business.executor;

import com.example.shared.exceptions.CeibaException;

import callback.UseCaseCallBk;

public interface PostExecutionThread {

    <V> void notifyResponse(final V response,
                            final UseCaseCallBk.UseCaseCallback<V> useCaseCallback);

    <V> void onError(CeibaException e,
                     final UseCaseCallBk.UseCaseCallback<V> useCaseCallback);
}
