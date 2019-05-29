package repository.datasource;

import com.example.business.models.Post;
import com.example.business.models.UserS;
import com.example.shared.exceptions.DBNoSuchElementException;
import com.example.shared.exceptions.NetworkException;
import com.example.shared.exceptions.ServerException;

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
    public UserS findUserById(Integer id) throws DBNoSuchElementException {
        UserEntity user = mUserDao.findById(id);

        if (user == null) {
            throw new DBNoSuchElementException();
        }
        return mUserMapper.entity2Model(user);
    }

    @Override
    public List<Post> findUserPosts(Integer id) throws ServerException, NetworkException {
        throw new UnsupportedOperationException();
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
