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

    MainView mView;
    UserBusinessHandler mUserBusiness;

    @Inject
    public MainPresenterImpl(MainView mView,
                             UserBusinessHandler mUserBusiness) {
        this.mView = mView;
        this.mUserBusiness = mUserBusiness;
    }

    @Override
    public void onCreate() {
        mUserBusiness.getUsersAsList(new UserParams(), new GetUsersResponse());
    }

    private class GetUsersResponse implements UseCaseCallBk.UseCaseCallback<List<UserS>> {

        @Override
        public void onSuccess(List<UserS> response) {

        }

        @Override
        public void onError(CeibaException error) {

        }
    }
}
