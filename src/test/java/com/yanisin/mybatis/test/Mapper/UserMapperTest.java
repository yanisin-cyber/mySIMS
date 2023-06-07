package com.yanisin.mybatis.test.Mapper;

import com.yanisin.sims.model.bean.User;
import com.yanisin.sims.model.mapper.UserMapper;
import com.yanisin.sims.model.util.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

import java.util.List;

public class UserMapperTest {

    static  {
        initSqlSessionUtils();
    }

    public static void initSqlSessionUtils() {
        SqlSessionUtils.setConfigurationPath("MyBatis/mybatis-config.xml");
        SqlSessionUtils.setAutoCommit(true);
    }

    @Test
    void testInsert() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);


        userMapper.insertUser(new User("U002", "adff", 0));
        if( !SqlSessionUtils.getAutoCommit() ) sqlSession.commit();
    }

    @Test
    void testDelete() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        userMapper.deleteUserById("GG Bond2");
        if( !SqlSessionUtils.getAutoCommit() ) sqlSession.commit();
    }

    @Test
    void testUpdate() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        userMapper.updateUser(new User("U002", "asdf", 0));
        if( !SqlSessionUtils.getAutoCommit() ) sqlSession.commit();
    }

    @Test
    void testSelectById() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        User user = userMapper.selectUserById("U001");
        if( !SqlSessionUtils.getAutoCommit() ) sqlSession.commit();

        System.out.println(user);
    }

    @Test
    void testSelectALL() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        List<User> users = userMapper.selectAllUser();
        if( !SqlSessionUtils.getAutoCommit() ) sqlSession.commit();

        System.out.println(users);
    }

    @Test
    void testCheackLogin() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        boolean is = userMapper.checkLogin("yanisin", "0000");
        if( !SqlSessionUtils.getAutoCommit() ) sqlSession.commit();

        System.out.println("login:" + is);
    }

    @Test
    void testIsSuperManager() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        boolean is = userMapper.isSuperManager("yanisin");
        if( !SqlSessionUtils.getAutoCommit() ) sqlSession.commit();

        System.out.println("superManager:" + is);
    }
}
