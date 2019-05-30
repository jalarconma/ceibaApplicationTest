package co.com.ceiba.mobile.pruebadeingreso.view;

import com.example.business.models.Post;
import com.example.business.models.UserS;

import java.util.List;

public interface PostView {

    void showErrorToast();

    void showProgress(boolean status);

    void setUserData(UserS response);

    void setPosts(List<Post> response);
}
