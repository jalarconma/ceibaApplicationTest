package co.com.ceiba.mobile.pruebadeingreso.view;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.business.models.UserS;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import co.com.ceiba.mobile.pruebadeingreso.BaseActivity;
import co.com.ceiba.mobile.pruebadeingreso.R;
import co.com.ceiba.mobile.pruebadeingreso.adapter.UserAdapter;
import co.com.ceiba.mobile.pruebadeingreso.adapter.listener.UserListener;
import co.com.ceiba.mobile.pruebadeingreso.di.component.AppComponent;
import co.com.ceiba.mobile.pruebadeingreso.di.component.DaggerMainComponent;
import co.com.ceiba.mobile.pruebadeingreso.di.module.MainModule;
import co.com.ceiba.mobile.pruebadeingreso.presenter.MainPresenter;

public class MainActivity extends BaseActivity implements MainView, UserListener {

    @Inject
    MainPresenter mPresenter;

    @BindView(R.id.textInputLayoutSearch)
    TextInputLayout textInputLayoutSearch;
    @BindView(R.id.recyclerViewSearchResults)
    RecyclerView recyclerViewSearchResults;

    UserAdapter mUserAdapter;

    @Override
    protected String getActivityName() {
        return MainActivity.class.getSimpleName();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        //showToolbar(toolbar, R.string.comments, true);

        initializeComponents();
        mPresenter.onCreate();
    }

    @Override
    protected void onStart() {
        super.onStart();

    }

    private void initializeComponents() {
        mUserAdapter = new UserAdapter(this, this);
        RecyclerView.LayoutManager layout = new LinearLayoutManager(this);
        recyclerViewSearchResults.setLayoutManager(layout);
        recyclerViewSearchResults.setAdapter(mUserAdapter);
    }

    @Override
    protected void initializeInjector(AppComponent applicationComponent) {
        DaggerMainComponent.builder().appComponent(applicationComponent)
                .mainModule(new MainModule(this))
                .build()
                .inject(this);
    }

    @Override
    public void setUsers(List<UserS> response) {
        mUserAdapter.setData(response);
    }

    @Override
    public void showErrorToast() {
        showToastMsg(R.string.generic_error);
    }

    @Override
    public void onGetPosts(Integer userId) {
        showToastMsg(R.string.generic_message_progress);
    }
}