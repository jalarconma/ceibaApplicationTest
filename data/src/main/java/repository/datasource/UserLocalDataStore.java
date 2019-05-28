package repository.datasource;

import com.example.business.models.UserS;

import java.util.List;

import javax.inject.Inject;

public class UserLocalDataStore implements UserDataStore {

    @Inject
    public UserLocalDataStore() {
    }

    @Override
    public List<UserS> getUsers() {
        return null;
    }
}
