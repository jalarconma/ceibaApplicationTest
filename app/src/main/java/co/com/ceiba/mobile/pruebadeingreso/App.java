package co.com.ceiba.mobile.pruebadeingreso;

import android.app.Application;

import co.com.ceiba.mobile.pruebadeingreso.di.component.AppComponent;
import co.com.ceiba.mobile.pruebadeingreso.di.component.DaggerAppComponent;
import co.com.ceiba.mobile.pruebadeingreso.di.module.AppModule;
import lombok.Getter;

public class App extends Application {

    @Getter
    private AppComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        initializeInjector();
    }

    private void initializeInjector() {
        applicationComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }
}
