package co.com.ceiba.mobile.pruebadeingreso.view;

import android.app.Activity;
import android.os.Bundle;

import javax.inject.Inject;

import co.com.ceiba.mobile.pruebadeingreso.BaseActivity;
import co.com.ceiba.mobile.pruebadeingreso.R;
import co.com.ceiba.mobile.pruebadeingreso.di.component.AppComponent;
import co.com.ceiba.mobile.pruebadeingreso.di.component.DaggerMainComponent;
import co.com.ceiba.mobile.pruebadeingreso.di.module.MainModule;
import co.com.ceiba.mobile.pruebadeingreso.presenter.MainPresenter;

public class MainActivity extends BaseActivity implements MainView {

    @Inject
    MainPresenter mPresenter;

    @Override
    protected String getActivityName() {
        return MainActivity.class.getSimpleName();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void initializeInjector(AppComponent applicationComponent) {
        DaggerMainComponent.builder().appComponent(applicationComponent)
                .mainModule(new MainModule(this))
                .build()
                .inject(this);
    }

    @Override
    public void showToast() {

    }
}