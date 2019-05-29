package co.com.ceiba.mobile.pruebadeingreso.presenter;

import com.example.business.models.Post;
import com.example.business.models.UserS;
import com.example.business.parameters.UserParams;
import com.example.handler.UserBusinessHandler;
import com.example.shared.exceptions.CeibaException;

import java.util.List;

import javax.inject.Inject;

import callback.UseCaseCallBk;
import co.com.ceiba.mobile.pruebadeingreso.view.PostView;

public class PostPresenterImpl implements PostPresenter {

    private PostView mView;
    private UserBusinessHandler mUserBusiness;

    private Integer mUserId;

    @Inject
    public PostPresenterImpl(PostView mView,
                             UserBusinessHandler mUserBusiness,
                             Integer mUserId) {
        this.mView = mView;
        this.mUserBusiness = mUserBusiness;
        this.mUserId = mUserId;
    }

    @Override
    public void onCreate() {
        mView.showProgress(false);
        mUserBusiness.findUser(new UserParams(mUserId, null), new GetUserResponse());
        mUserBusiness.findUserPosts(new UserParams(mUserId, null), new GetPostsResponse());
    }

    private class GetUserResponse implements UseCaseCallBk.UseCaseCallback<UserS> {

        @Override
        public void onSuccess(UserS response) {
            mView.showProgress(false);
            mView.setUserData(response);
        }

        @Override
        public void onError(CeibaException error) {
            mView.showProgress(false);
            mView.showErrorToast();
        }
    }

    private class GetPostsResponse implements UseCaseCallBk.UseCaseCallback<List<Post>> {

        @Override
        public void onSuccess(List<Post> response) {
            mView.showProgress(false);
            mView.setPosts(response);
        }

        @Override
        public void onError(CeibaException error) {
            mView.showProgress(false);
            mView.showErrorToast();
        }
    }
}
