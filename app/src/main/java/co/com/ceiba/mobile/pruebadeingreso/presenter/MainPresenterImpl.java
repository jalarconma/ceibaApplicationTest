package co.com.ceiba.mobile.pruebadeingreso.presenter;

import com.example.business.models.UserS;
import com.example.business.parameters.UserParams;
import com.example.handler.UserBusinessHandler;
import com.example.shared.exceptions.CeibaException;

import java.util.List;

import javax.inject.Inject;

import callback.UseCaseCallBk;
import co.com.ceiba.mobile.pruebadeingreso.view.MainView;

public class MainPresenterImpl implements MainPresenter {

    private MainView mView;
    private UserBusinessHandler mUserBusiness;

    @Inject
    public MainPresenterImpl(MainView mView,
                             UserBusinessHandler mUserBusiness) {
        this.mView = mView;
        this.mUserBusiness = mUserBusiness;
    }

    @Override
    public void onCreate() {
        mView.showProgress(true);
        mUserBusiness.getUsersAsList(new UserParams(null), new GetUsersResponse());
    }

    @Override
    public void onFilterUsers(String name) {
        mView.showProgress(true);
        mUserBusiness.getUsersByName(new UserParams(name), new FilterUsersResponse());
    }

    private class GetUsersResponse implements UseCaseCallBk.UseCaseCallback<List<UserS>> {

        @Override
        public void onSuccess(List<UserS> response) {
            mView.setUsers(response);
            mView.showProgress(false);
        }

        @Override
        public void onError(CeibaException error) {
            mView.showErrorToast();
            mView.showProgress(false);
        }
    }

    private class FilterUsersResponse implements UseCaseCallBk.UseCaseCallback<List<UserS>> {

        @Override
        public void onSuccess(List<UserS> response) {
            mView.setUsers(response);
            mView.showProgress(false);
        }

        @Override
        public void onError(CeibaException error) {
            mView.showErrorToast();
            mView.showProgress(false);
        }
    }
}
