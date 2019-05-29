package db.user;

import java.util.List;

import javax.inject.Inject;

public class UserDao {

    @Inject
    public UserDao() {
    }

    public List<UserEntity> findUsersByName(String name) {
        return null;
    }
}
