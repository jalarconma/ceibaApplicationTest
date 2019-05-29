package repository.datasource;

import com.example.business.models.UserS;

import java.util.List;

import javax.inject.Inject;

import db.user.UserDao;
import db.user.UserEntity;
import mappers.UserMapper;

public class UserLocalDataStore implements UserDataStore {

    private UserDao mUserDao;
    private UserMapper mUserMapper;

    @Inject
    public UserLocalDataStore(UserDao mUserDao,
                              UserMapper mUserMapper) {
        this.mUserDao = mUserDao;
        this.mUserMapper = mUserMapper;
    }

    @Override
    public List<UserS> getUsers() {
        List<UserEntity> users = mUserDao.findAll();
        return mUserMapper.entity2Model(users);
    }

    @Override
    public List<UserS> getUsersByName(String name) {
        List<UserEntity> users = mUserDao.findByName(name);
        return mUserMapper.entity2Model(users);
    }

    @Override
    public List<UserS> createUsers(List<UserS> users) {

        for (UserS user : users) {
            UserEntity entity = mUserMapper.model2Entity(user);
            entity.save();
        }

        return getUsers();
    }
}
