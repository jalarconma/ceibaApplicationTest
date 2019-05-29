package co.com.ceiba.mobile.pruebadeingreso;

import android.app.Application;

import com.raizlabs.android.dbflow.config.FlowConfig;
import com.raizlabs.android.dbflow.config.FlowManager;

import co.com.ceiba.mobile.pruebadeingreso.di.component.AppComponent;
import co.com.ceiba.mobile.pruebadeingreso.di.component.DaggerAppComponent;
import co.com.ceiba.mobile.pruebadeingreso.di.module.AppModule;
import co.com.ceiba.mobile.pruebadeingreso.di.module.MapperModule;
import co.com.ceiba.mobile.pruebadeingreso.di.module.NetModule;
import lombok.Getter;

public class App extends Application {

    @Getter
    private AppComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        //DBFLow
        FlowManager.init(new FlowConfig.Builder(this).build());

        initializeInjector();
    }

    private void initializeInjector() {
        applicationComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .netModule(new NetModule(this))
                .mapperModule(new MapperModule())
                .build();
    }
}
