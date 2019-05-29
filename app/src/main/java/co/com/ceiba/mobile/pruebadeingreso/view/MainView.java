package co.com.ceiba.mobile.pruebadeingreso.view;

import com.example.business.models.UserS;

import java.util.List;

public interface MainView {

    void setUsers(List<UserS> response);

    void showErrorToast();

    void showProgress(boolean status);
}
