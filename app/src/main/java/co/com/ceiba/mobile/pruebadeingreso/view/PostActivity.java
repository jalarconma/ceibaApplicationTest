package co.com.ceiba.mobile.pruebadeingreso.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.business.models.Post;
import com.example.business.models.UserS;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import co.com.ceiba.mobile.pruebadeingreso.BaseActivity;
import co.com.ceiba.mobile.pruebadeingreso.R;
import co.com.ceiba.mobile.pruebadeingreso.adapter.PostAdapter;
import co.com.ceiba.mobile.pruebadeingreso.di.component.AppComponent;
import co.com.ceiba.mobile.pruebadeingreso.di.component.DaggerPostComponent;
import co.com.ceiba.mobile.pruebadeingreso.di.module.PostModule;
import co.com.ceiba.mobile.pruebadeingreso.presenter.PostPresenter;

public class PostActivity extends BaseActivity implements PostView {

    @Inject
    PostPresenter mPresenter;

    @BindView(R.id.name)
    TextView name;
    @BindView(R.id.phone)
    TextView phone;
    @BindView(R.id.email)
    TextView email;
    @BindView(R.id.recyclerViewPostsResults)
    RecyclerView recyclerViewPostsResults;
    @BindView(R.id.progressBar)
    ProgressBar progressBar;

    PostAdapter mPostAdapter;

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
        mPostAdapter = new PostAdapter(this);
        RecyclerView.LayoutManager layout = new LinearLayoutManager(this);
        recyclerViewPostsResults.setLayoutManager(layout);
        recyclerViewPostsResults.setAdapter(mPostAdapter);
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
        progressBar.setVisibility(status ? View.VISIBLE :View.GONE);
    }

    @Override
    public void setUserData(UserS response) {
        name.setText(response.getName());
        phone.setText(response.getPhone());
        email.setText(response.getEmail());
    }

    @Override
    public void setPosts(List<Post> response) {
        mPostAdapter.setData(response);
    }
}
