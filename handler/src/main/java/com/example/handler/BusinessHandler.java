package com.example.handler;

import com.example.business.IParameter;
import com.example.business.executor.PostExecutionThread;
import com.example.business.executor.ThreadExecutor;
import com.example.shared.exceptions.CeibaException;

import callback.UseCaseCallBk;

public class BusinessHandler {

    private final ThreadExecutor mThreadExecutor;
    private final PostExecutionThread mPostExecutionThread;

    public BusinessHandler(ThreadExecutor mThreadExecutor, PostExecutionThread mPostExecutionThread) {
        this.mThreadExecutor = mThreadExecutor;
        this.mPostExecutionThread = mPostExecutionThread;
    }

    @SuppressWarnings("unchecked")
    protected <V> void execute(opBusinessNoParam<V> runnable, UseCaseCallBk.UseCaseCallback<V> callback) {
        UiCallbackWrapper calb = new UiCallbackWrapper(callback, this);
        mThreadExecutor.execute(() -> runnable.accept(calb));
    }


    @SuppressWarnings("unchecked")
    protected <P extends IParameter, V> void execute(opBusiness<P, V> runnable, P params, UseCaseCallBk.UseCaseCallback<V> callback) {
        UiCallbackWrapper calb = new UiCallbackWrapper(callback, this);
        mThreadExecutor.execute(() -> runnable.accept(params, calb));
    }

    private <V> void notifyResponse(final V response,
                                    final UseCaseCallBk.UseCaseCallback<V> useCaseCallback) {
        mPostExecutionThread.notifyResponse(response, useCaseCallback);
    }

    private <V> void notifyError(final CeibaException error,
                                 final UseCaseCallBk.UseCaseCallback<V> useCaseCallback) {
        mPostExecutionThread.onError(error, useCaseCallback);
    }

    protected interface opBusiness<T extends IParameter, V> {
        void accept(T parameter, UseCaseCallBk.UseCaseCallback<V> callback);
    }

    protected interface opBusinessNoParam<V> {
        void accept(UseCaseCallBk.UseCaseCallback<V> callback);
    }

    private static final class UiCallbackWrapper<V> implements
            UseCaseCallBk.UseCaseCallback<V> {
        private final UseCaseCallBk.UseCaseCallback<V> mCallback;
        private final BusinessHandler mBusinessHandler;

        UiCallbackWrapper(UseCaseCallBk.UseCaseCallback<V> callback,
                          BusinessHandler useCaseHandler) {
            mCallback = callback;
            mBusinessHandler = useCaseHandler;
        }

        @Override
        public void onSuccess(V response) {
            mBusinessHandler.notifyResponse(response, mCallback);
        }

        @Override
        public void onError(CeibaException error) {
            mBusinessHandler.notifyError(error, mCallback);
        }
    }
}
