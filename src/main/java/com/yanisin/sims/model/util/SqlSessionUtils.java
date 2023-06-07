package com.yanisin.sims.model.util;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class SqlSessionUtils {
    private static String configurationPath = "resources/";
    private static boolean autoCommit = false;


    public static void setConfigurationPath(String path) {
        configurationPath = path;
    }

    public static String getConfigurationPath() {
        return configurationPath;
    }

    public static void setAutoCommit(boolean yon) {
        autoCommit = yon;
    }

    public static boolean getAutoCommit() {
        return autoCommit;
    }

    public static SqlSession getSqlSession() {
        InputStream inputStream;
        SqlSession sqlSession = null;
        try {
            inputStream = Resources.getResourceAsStream(SqlSessionUtils.getConfigurationPath());
            SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
            SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
            sqlSession = sqlSessionFactory.openSession(SqlSessionUtils.getAutoCommit());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sqlSession;
    }

    public static SqlSession getSqlSession(String path) {
        SqlSessionUtils.setConfigurationPath(path);
        return getSqlSession();
    }

    public static SqlSession getSqlSession(String path, boolean isAuto) {
        SqlSessionUtils.setConfigurationPath(path);
        setAutoCommit(isAuto);

        return getSqlSession();
    }
}
