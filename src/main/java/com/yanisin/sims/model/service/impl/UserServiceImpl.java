package com.yanisin.sims.model.service.impl;

import com.yanisin.sims.model.bean.User;
import com.yanisin.sims.model.mapper.UserMapper;
import com.yanisin.sims.model.service.intfa.UserService;
import com.yanisin.sims.model.util.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * @Author: Yanisin
 * @Date: 2023/5/28 20:14
 * @PackageName: com.yanisin.sims.model.service.impl
 * @ClassName: UserServiceImpl
 * @Description: //TODO
 **/

public class UserServiceImpl implements UserService {

    private UserMapper userMapper;

    public UserServiceImpl() {
        SqlSessionUtils.setConfigurationPath("MyBatis/mybatis-config.xml");
        SqlSessionUtils.setAutoCommit(true);
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        this.userMapper = sqlSession.getMapper(UserMapper.class);
    };

    @Override
    public boolean insertUser(User user) {
        return userMapper.insertUser(user) > 0 ;
    }

    @Override
    public boolean updateUser(User user) {
        return userMapper.updateUser(user) > 0;
    }

    @Override
    public boolean deleteUserById(String userId) {
        return userMapper.deleteUserById(userId) > 0;
    }

    @Override
    public User getUserById(String userId) {
        return userMapper.selectUserById(userId);
    }

    @Override
    public List<User> gectAllUsers() {
        return userMapper.selectAllUser();
    }

    @Override
    public boolean checkLogin(String userId, String userPassword) {
        return userMapper.checkLogin(userId, userPassword);
    }

    @Override
    public boolean isSuperManager(String userId) {
        return userMapper.isSuperManager(userId);
    }
}
