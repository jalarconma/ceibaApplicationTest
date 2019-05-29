package repository.datasource;

import com.example.business.UserRepository;
import com.example.business.models.UserS;

import java.util.List;

public interface UserDataStore extends UserRepository {

    List<UserS> createUsers(List<UserS> users);
}
