package co.com.ceiba.mobile.pruebadeingreso.di.module;

import co.com.ceiba.mobile.pruebadeingreso.di.PerActivity;
import co.com.ceiba.mobile.pruebadeingreso.presenter.PostPresenter;
import co.com.ceiba.mobile.pruebadeingreso.presenter.PostPresenterImpl;
import co.com.ceiba.mobile.pruebadeingreso.view.PostView;
import dagger.Module;
import dagger.Provides;

@Module
public class PostModule {

    private PostView mView;
    private Integer mUserId;

    public PostModule(PostView mView,
                      Integer mUserId) {
        this.mView = mView;
        this.mUserId = mUserId;
    }

    @Provides
    @PerActivity
    PostView provideView() {
        return mView;
    }

    @Provides
    @PerActivity
    PostPresenter providePresenter(PostPresenterImpl presenter) {
        return presenter;
    }

    @Provides
    @PerActivity
    Integer provideUserId() {
        return mUserId;
    }

}
