package com.yanisin.mybatis.test.Mapper;

import com.yanisin.sims.model.bean.Lesson;
import com.yanisin.sims.model.mapper.LessonMapper;
import com.yanisin.sims.model.util.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

import java.util.List;

public class LessionMapperTest {

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
        LessonMapper lessonMapper = sqlSession.getMapper(LessonMapper.class);


        lessonMapper.insertLesson(new Lesson("S001","CSE002", "T001", 0));
        if( !SqlSessionUtils.getAutoCommit() ) sqlSession.commit();
    }

    @Test
    void testDelete() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        LessonMapper lessonMapper = sqlSession.getMapper(LessonMapper.class);

        lessonMapper.deleteLessonById("S001","CSE002", "T001");
        if( !SqlSessionUtils.getAutoCommit() ) sqlSession.commit();
    }

    @Test
    void testUpdate() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        LessonMapper lessonMapper = sqlSession.getMapper(LessonMapper.class);

        lessonMapper.updateLesson(new Lesson("S001","CSE002", "T001", 100));
        if( !SqlSessionUtils.getAutoCommit() ) sqlSession.commit();
    }

    @Test
    void testSelectById() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        LessonMapper lessonMapper = sqlSession.getMapper(LessonMapper.class);

        Lesson lesson = lessonMapper.selectLessonById("S001","CSE001", "T001");
        if( !SqlSessionUtils.getAutoCommit() ) sqlSession.commit();

        System.out.println(lesson);
    }

    @Test
    void testSelectALL() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        LessonMapper lessonMapper = sqlSession.getMapper(LessonMapper.class);

        List<Lesson> lessons = lessonMapper.selectAllLesson();
        if( !SqlSessionUtils.getAutoCommit() ) sqlSession.commit();

        System.out.println(lessons);
    }
}
