package co.com.ceiba.mobile.pruebadeingreso.di.module;

import co.com.ceiba.mobile.pruebadeingreso.di.PerActivity;
import co.com.ceiba.mobile.pruebadeingreso.presenter.MainPresenter;
import co.com.ceiba.mobile.pruebadeingreso.presenter.MainPresenterImpl;
import co.com.ceiba.mobile.pruebadeingreso.view.MainView;
import dagger.Module;
import dagger.Provides;

@Module
public class MainModule {

    private MainView mView;

    public MainModule(MainView mView) {
        this.mView = mView;
    }

    @Provides
    @PerActivity
    MainView provideView() {
        return mView;
    }

    @Provides
    @PerActivity
    MainPresenter providePresenter(MainPresenterImpl presenter) {
        return presenter;
    }
}
