package net.services;

import net.services.dto.UserDTO;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface UserApiService {

    @GET("/users")
    Call<List<UserDTO>> findUsers();
}
