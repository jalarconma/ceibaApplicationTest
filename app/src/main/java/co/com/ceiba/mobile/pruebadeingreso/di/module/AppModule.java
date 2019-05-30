package co.com.ceiba.mobile.pruebadeingreso.di.module;

import android.app.Application;
import android.content.Context;

import com.example.business.executor.PostExecutionThread;
import com.example.business.executor.ThreadExecutor;
import com.example.data.executor.JobExecutor;

import javax.inject.Singleton;

import co.com.ceiba.mobile.pruebadeingreso.App;
import co.com.ceiba.mobile.pruebadeingreso.UIThread;
import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    private App app;

    public AppModule(App app) {
        this.app = app;
    }

    @Provides
    @Singleton
    Application providerApplication() {
        return app;
    }

    @Provides
    @Singleton
    App providerApp() {
        return app;
    }

    @Provides
    @Singleton
    Context providerContext() {
        return app;
    }

    @Provides
    @Singleton
    ThreadExecutor provideThreadExecutor(JobExecutor jobExecutor) {
        return jobExecutor;
    }

    @Provides
    @Singleton
    PostExecutionThread providePostExecutionThread(UIThread uiThread) {
        return uiThread;
    }
}
