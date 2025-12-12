package com.vishwjeet.User.Service.Service;

import com.vishwjeet.User.Service.Entity.User;

import java.util.List;

public interface UserService {

          User SaveUser(User user);

          List<User>GetAllUser();

          User GetUser(Long User_id);
}
