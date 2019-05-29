package repository.datasource;

import com.example.business.models.UserS;
import com.example.shared.exceptions.NetworkException;
import com.example.shared.exceptions.ServerException;

import net.services.UserApiService;
import net.services.dto.UserDTO;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;

import db.user.UserEntity;
import mappers.UserMapper;
import retrofit2.Call;
import retrofit2.Response;

public class UserCloudDataStore implements UserDataStore {

    private UserApiService mUserApiService;
    private UserMapper mUserMapper;

    @Inject
    public UserCloudDataStore(UserApiService mUserApiService,
                              UserMapper mUserMapper) {
        this.mUserApiService = mUserApiService;
        this.mUserMapper = mUserMapper;
    }

    @Override
    public List<UserS> getUsers() throws ServerException, NetworkException {
        Call<List<UserDTO>> callResp = mUserApiService.findUsers();
        try {
            Response<List<UserDTO>> response = callResp.execute();
            if (!response.isSuccessful()) {
                throw new ServerException("Error en el servidor al descargar los sistemas del plan");
            } else {
                List<UserDTO> dtos = response.body();
                List<UserEntity> users = mUserMapper.dto2Entity(dtos);
                return mUserMapper.entity2Model(users);
            }
        } catch (IOException e) {
            throw new NetworkException("No hay conexión a Internet");
        }
    }

    @Override
    public List<UserS> createUsers(List<UserS> users) {
        throw new UnsupportedOperationException();
    }
}
