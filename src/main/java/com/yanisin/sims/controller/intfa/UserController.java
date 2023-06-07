package com.yanisin.sims.controller.intfa;

import com.yanisin.sims.model.bean.User;

import java.util.List;

/**
 * @Author: Yanisin
 * @Date: 2023/6/8 0:28
 * @PackageName: com.yanisin.sims.controller.intfa
 * @IntefaceName: UserController
 * @Description: //TODO
 **/
public interface UserController {
    boolean insertUser(User user);

    boolean updateUser(User user);

    boolean deleteUserById(String userId);

    User getUserById(String userId);

    List<User> gectAllUsers();

    boolean checkLogin(String userId, String userPassword);

    boolean isSuperManager(String userId);
}
