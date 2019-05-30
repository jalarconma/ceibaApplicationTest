package co.com.ceiba.mobile.pruebadeingreso.di.component;

import android.content.Context;

import com.example.handler.UserBusinessHandler;

import javax.inject.Singleton;

import co.com.ceiba.mobile.pruebadeingreso.App;
import co.com.ceiba.mobile.pruebadeingreso.di.module.AppModule;
import co.com.ceiba.mobile.pruebadeingreso.di.module.MapperModule;
import co.com.ceiba.mobile.pruebadeingreso.di.module.NetModule;
import co.com.ceiba.mobile.pruebadeingreso.di.module.RepositoryModule;
import dagger.Component;

@Singleton
@Component(modules = {AppModule.class, NetModule.class, MapperModule.class, RepositoryModule.class})
public interface AppComponent {

    Context getContext();
    App app();

    UserBusinessHandler userBusinessHandler();
}
