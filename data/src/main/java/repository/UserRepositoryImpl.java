package repository;

import com.example.business.UserRepository;
import com.example.business.models.Post;
import com.example.business.models.UserS;
import com.example.shared.exceptions.DBNoSuchElementException;
import com.example.shared.exceptions.NetworkException;
import com.example.shared.exceptions.ServerException;

import java.util.List;

import javax.inject.Inject;

import di.Cloud;
import di.Local;
import repository.datasource.UserDataStore;

public class UserRepositoryImpl implements UserRepository {

    private UserDataStore mUserLocalDataStore;
    private UserDataStore mUserCloudDataStore;

    @Inject
    public UserRepositoryImpl(@Local UserDataStore mUserLocalDataStore,
                              @Cloud UserDataStore mUserCloudDataStore) {
        this.mUserLocalDataStore = mUserLocalDataStore;
        this.mUserCloudDataStore = mUserCloudDataStore;
    }

    @Override
    public List<UserS> getUsers() throws ServerException, NetworkException {
        List<UserS> users = mUserLocalDataStore.getUsers();

        if (users.isEmpty()) {
            users = mUserCloudDataStore.getUsers();
            users = mUserLocalDataStore.createUsers(users);
        }

        return users;
    }

    @Override
    public List<UserS> getUsersByName(String name) {
        return mUserLocalDataStore.getUsersByName(name);
    }

    @Override
    public UserS findUserById(Integer id) throws DBNoSuchElementException {
        return mUserLocalDataStore.findUserById(id);
    }

    @Override
    public List<Post> findUserPosts(Integer id) throws ServerException, NetworkException {
        return mUserCloudDataStore.findUserPosts(id);
    }
}
