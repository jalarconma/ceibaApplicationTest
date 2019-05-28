package repository.datasource;

import com.example.business.models.UserS;

import java.util.List;

import javax.inject.Inject;

public class UserCloudDataStore implements UserDataStore {

    @Inject
    public UserCloudDataStore() {
    }

    @Override
    public List<UserS> getUsers() {
        return null;
    }
}
