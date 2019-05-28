package com.example.business;

import com.example.business.models.UserS;

import java.util.List;

public interface UserRepository {

    List<UserS> getUsers();
}
