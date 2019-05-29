package net.services;

import com.example.business.models.Post;

import net.services.dto.UserDTO;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface UserApiService {

    @GET("/users")
    Call<List<UserDTO>> findUsers();

    @GET("/posts")
    Call<List<Post>> findUserPosts(@Query("userId") Integer id);
}
