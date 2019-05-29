package co.com.ceiba.mobile.pruebadeingreso.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.example.business.models.Post;
import com.example.business.models.UserS;

import java.util.List;

import javax.inject.Inject;

import butterknife.ButterKnife;
import co.com.ceiba.mobile.pruebadeingreso.BaseActivity;
import co.com.ceiba.mobile.pruebadeingreso.R;
import co.com.ceiba.mobile.pruebadeingreso.di.component.AppComponent;
import co.com.ceiba.mobile.pruebadeingreso.di.component.DaggerPostComponent;
import co.com.ceiba.mobile.pruebadeingreso.di.module.PostModule;
import co.com.ceiba.mobile.pruebadeingreso.presenter.PostPresenter;

public class PostActivity extends BaseActivity implements PostView {

    @Inject
    PostPresenter mPresenter;

    private Integer mUserId;

    @Override
    protected String getActivityName() {
        return PostActivity.class.getSimpleName();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);

        ButterKnife.bind(this);

        initializeComponents();
        mPresenter.onCreate();
    }

    private void initializeComponents() {
        //TODO
    }

    @Override
    protected void initializeInjector(AppComponent applicationComponent) {
        Intent intent = getIntent();
        mUserId = intent.getIntExtra("userId", -1);

        DaggerPostComponent.builder().appComponent(applicationComponent)
                .postModule(new PostModule(this, mUserId))
                .build()
                .inject(this);
    }

    @Override
    public void showErrorToast() {
        showToastMsg(R.string.generic_error);
    }

    @Override
    public void showProgress(boolean status) {
        //TODO
    }

    @Override
    public void setUserData(UserS response) {
        //TODO
    }

    @Override
    public void setPosts(List<Post> response) {
        //TODO
    }
}
