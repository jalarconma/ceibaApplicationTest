package com.example.business;

import com.example.business.models.Post;
import com.example.business.models.UserS;
import com.example.shared.exceptions.DBNoSuchElementException;
import com.example.shared.exceptions.NetworkException;
import com.example.shared.exceptions.ServerException;

import java.util.List;

public interface UserRepository {

    List<UserS> getUsers() throws ServerException, NetworkException;

    List<UserS> getUsersByName(String name);

    UserS findUserById(Integer id) throws DBNoSuchElementException;

    List<Post> findUserPosts(Integer id) throws ServerException, NetworkException;
}
