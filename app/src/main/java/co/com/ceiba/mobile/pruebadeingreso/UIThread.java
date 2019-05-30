package co.com.ceiba.mobile.pruebadeingreso;

import android.os.Handler;
import android.os.Looper;

import com.example.business.executor.PostExecutionThread;
import com.example.shared.exceptions.CeibaException;

import javax.inject.Inject;
import javax.inject.Singleton;

import callback.UseCaseCallBk;

@Singleton
public class UIThread implements PostExecutionThread {

    private final Handler mHandler;

    @Inject
    public UIThread() {
        this.mHandler = new Handler(Looper.getMainLooper());
    }

    @Override
    public <V> void notifyResponse(final V response,
                                   final UseCaseCallBk.UseCaseCallback<V> useCaseCallback) {
        mHandler.post(new Runnable() {
            @Override
            public void run() {
                useCaseCallback.onSuccess(response);
            }
        });
    }

    @Override
    public <V> void onError(final CeibaException e,
                            final UseCaseCallBk.UseCaseCallback<V> useCaseCallback) {
        mHandler.post(new Runnable() {
            @Override
            public void run() {
                useCaseCallback.onError(e);
            }
        });
    }
}
