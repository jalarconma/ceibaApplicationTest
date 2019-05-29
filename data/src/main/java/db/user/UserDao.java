package db.user;

import com.raizlabs.android.dbflow.sql.language.SQLite;

import java.util.List;

import javax.inject.Inject;

public class UserDao {

    @Inject
    public UserDao() {
    }

    public List<UserEntity> findUsersByName(String name) {
        return null;
    }

    public List<UserEntity> findAll() {
        return SQLite.select().from(UserEntity.class)
                .queryList();
    }
}
