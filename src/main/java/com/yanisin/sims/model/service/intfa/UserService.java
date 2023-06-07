package com.yanisin.sims.model.service.intfa;

import com.yanisin.sims.model.bean.User;

import java.util.List;

/**
 * @Author: Yanisin
 * @Date: 2023/5/28 15:12
 * @PackageName: com.yanisin.sims.model.service.intfe
 * @IntefaceName: UserService
 * @Description: //TODO
 **/

public interface UserService {
    boolean insertUser(User user);

    boolean updateUser(User user);

    boolean deleteUserById(String userId);

    User getUserById(String userId);

    List<User> gectAllUsers();

    boolean checkLogin(String userId, String userPassword);

    boolean isSuperManager(String userId);
}
