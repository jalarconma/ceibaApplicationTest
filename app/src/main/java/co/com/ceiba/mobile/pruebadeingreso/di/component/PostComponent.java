package co.com.ceiba.mobile.pruebadeingreso.di.component;

import co.com.ceiba.mobile.pruebadeingreso.di.PerActivity;
import co.com.ceiba.mobile.pruebadeingreso.di.module.PostModule;
import co.com.ceiba.mobile.pruebadeingreso.view.PostActivity;
import dagger.Component;

@PerActivity
@Component(dependencies = AppComponent.class,
        modules = {PostModule.class})
public interface PostComponent {

    void inject (PostActivity activity);
}
