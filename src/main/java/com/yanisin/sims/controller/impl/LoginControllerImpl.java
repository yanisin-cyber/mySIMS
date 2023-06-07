package com.yanisin.sims.controller.impl;

import com.yanisin.sims.controller.intfa.LoginController;
import com.yanisin.sims.model.service.impl.UserServiceImpl;
import com.yanisin.sims.model.service.intfa.UserService;

/**
 * @Author: Yanisin
 * @Date: 2023/5/31 17:24
 * @PackageName: com.yanisin.sims.controller
 * @ClassName: UserController
 * @Description: //TODO
 **/
public class LoginControllerImpl implements LoginController {
    private UserService userService = new UserServiceImpl();
    @Override
    public boolean isValidLogin(String username, String password) {
        return userService.checkLogin(username, password);
    }
}
