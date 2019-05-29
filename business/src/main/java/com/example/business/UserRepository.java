package com.example.business;

import com.example.business.models.UserS;
import com.example.shared.exceptions.NetworkException;
import com.example.shared.exceptions.ServerException;

import java.util.List;

public interface UserRepository {

    List<UserS> getUsers() throws ServerException, NetworkException;
}
