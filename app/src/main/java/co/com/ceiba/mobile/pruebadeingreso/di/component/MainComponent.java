package co.com.ceiba.mobile.pruebadeingreso.di.component;

import co.com.ceiba.mobile.pruebadeingreso.di.PerActivity;
import co.com.ceiba.mobile.pruebadeingreso.di.module.MainModule;
import co.com.ceiba.mobile.pruebadeingreso.view.MainActivity;
import dagger.Component;

@PerActivity
@Component(dependencies = AppComponent.class,
        modules = {MainModule.class})
public interface MainComponent {

    void inject (MainActivity activity);
}
