package db.user;

import com.raizlabs.android.dbflow.sql.language.SQLite;

import java.util.List;

import javax.inject.Inject;

public class UserDao {

    @Inject
    public UserDao() {
    }

    public List<UserEntity> findByName(String name) {
        return SQLite.select().from(UserEntity.class)
                .where(UserEntity_Table.name.like("%" + name + "%"))
                .queryList();
    }

    public List<UserEntity> findAll() {
        return SQLite.select().from(UserEntity.class)
                .queryList();
    }

    public UserEntity findById(Integer id) {
        return SQLite.select().from(UserEntity.class)
                .where(UserEntity_Table.id.eq(id.longValue()))
                .querySingle();
    }
}
