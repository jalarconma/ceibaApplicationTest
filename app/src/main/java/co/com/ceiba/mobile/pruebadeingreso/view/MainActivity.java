package co.com.ceiba.mobile.pruebadeingreso.view;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;

import com.example.business.models.UserS;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;
import co.com.ceiba.mobile.pruebadeingreso.BaseActivity;
import co.com.ceiba.mobile.pruebadeingreso.R;
import co.com.ceiba.mobile.pruebadeingreso.di.component.AppComponent;
import co.com.ceiba.mobile.pruebadeingreso.di.component.DaggerMainComponent;
import co.com.ceiba.mobile.pruebadeingreso.di.module.MainModule;
import co.com.ceiba.mobile.pruebadeingreso.presenter.MainPresenter;

public class MainActivity extends BaseActivity implements MainView {

    @Inject
    MainPresenter mPresenter;

    @BindView(R.id.textInputLayoutSearch)
    TextInputLayout textInputLayoutSearch;

    @Override
    protected String getActivityName() {
        return MainActivity.class.getSimpleName();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPresenter.onCreate();
    }

    @Override
    protected void initializeInjector(AppComponent applicationComponent) {
        DaggerMainComponent.builder().appComponent(applicationComponent)
                .mainModule(new MainModule(this))
                .build()
                .inject(this);
    }

    @OnClick(R.id.textInputLayoutSearch)
    public void onSearchClick() {
        mPresenter.onCreate();
    }

    @OnClick(R.id.editTextSearch)
    public void onEditClick() {
        mPresenter.onCreate();
    }

    @OnClick(R.id.content)
    public void onContentClick() {
        mPresenter.onCreate();
    }

    @Override
    public void setUsers(List<UserS> response) {

    }

    @Override
    public void showErrorToast() {

    }
}