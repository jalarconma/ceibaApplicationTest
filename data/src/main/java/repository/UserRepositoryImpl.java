package repository;

import com.example.business.UserRepository;
import com.example.business.models.UserS;

import java.util.List;

import javax.inject.Inject;

public class UserRepositoryImpl implements UserRepository {

    @Inject
    public UserRepositoryImpl() {
    }

    @Override
    public List<UserS> getUsers() {
        return null;
    }
}
