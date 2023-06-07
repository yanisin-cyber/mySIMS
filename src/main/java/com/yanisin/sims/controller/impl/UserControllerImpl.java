package com.yanisin.sims.controller.impl;

import com.yanisin.sims.controller.intfa.UserController;
import com.yanisin.sims.model.bean.User;
import com.yanisin.sims.model.service.impl.UserServiceImpl;
import com.yanisin.sims.model.service.intfa.UserService;

import java.util.List;

/**
 * @Author: Yanisin
 * @Date: 2023/6/8 0:29
 * @PackageName: com.yanisin.sims.controller.impl
 * @ClassName: UserControllerImpl
 * @Description: //TODO
 **/
public class UserControllerImpl implements UserController {
    private UserService userService = new UserServiceImpl();
    @Override
    public boolean insertUser(User user) {
        return userService.insertUser(user);
    }

    @Override
    public boolean updateUser(User user) {
        return userService.updateUser(user);
    }

    @Override
    public boolean deleteUserById(String userId) {
        return userService.deleteUserById(userId);
    }

    @Override
    public User getUserById(String userId) {
        return userService.getUserById(userId);
    }

    @Override
    public List<User> gectAllUsers() {
        return userService.gectAllUsers();
    }

    @Override
    public boolean checkLogin(String userId, String userPassword) {
        return userService.checkLogin(userId, userPassword);
    }

    @Override
    public boolean isSuperManager(String userId) {
        return userService.isSuperManager(userId);
    }
}
