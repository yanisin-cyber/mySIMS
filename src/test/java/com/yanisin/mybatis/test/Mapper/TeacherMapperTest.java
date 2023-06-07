package com.yanisin.mybatis.test.Mapper;

import com.yanisin.sims.model.bean.Classe;
import com.yanisin.sims.model.bean.Course;
import com.yanisin.sims.model.bean.Department;
import com.yanisin.sims.model.bean.Teacher;
import com.yanisin.sims.model.mapper.TeacherMapper;
import com.yanisin.sims.model.util.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

import java.util.List;

public class TeacherMapperTest {

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
        TeacherMapper teacherMapper = sqlSession.getMapper(TeacherMapper.class);


        teacherMapper.insertTeacher(new Teacher("T003", "zhoubei", "副教授", "D001"));
        if( !SqlSessionUtils.getAutoCommit() ) sqlSession.commit();
    }

    @Test
    void testDelete() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        TeacherMapper teacherMapper = sqlSession.getMapper(TeacherMapper.class);

        teacherMapper.deleteTeacherById("T002");
        if( !SqlSessionUtils.getAutoCommit() ) sqlSession.commit();
    }

    @Test
    void testUpdate() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        TeacherMapper teacherMapper = sqlSession.getMapper(TeacherMapper.class);

        teacherMapper.updateTeacher(new Teacher("T003", "zhoubei", "讲师", "D001"));
        if( !SqlSessionUtils.getAutoCommit() ) sqlSession.commit();
    }

    @Test
    void testSelectById() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        TeacherMapper teacherMapper = sqlSession.getMapper(TeacherMapper.class);

        Teacher teacher = teacherMapper.selectTeacherById("T002");
        if( !SqlSessionUtils.getAutoCommit() ) sqlSession.commit();

        System.out.println(teacher);
    }

    @Test
    void testSelectALL() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        TeacherMapper teacherMapper = sqlSession.getMapper(TeacherMapper.class);

        List<Teacher> teachers = teacherMapper.selectAllTeacher();
        if( !SqlSessionUtils.getAutoCommit() ) sqlSession.commit();

        System.out.println(teachers);
    }

    @Test
    void testSelectManagedClasse() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        TeacherMapper teacherMapper = sqlSession.getMapper(TeacherMapper.class);

        List<Classe> classes = teacherMapper.selectManagedClasse("T001");
        if( !SqlSessionUtils.getAutoCommit() ) sqlSession.commit();

        System.out.println(classes);
    }

    @Test
    void testSelectTeachedCourse() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        TeacherMapper teacherMapper = sqlSession.getMapper(TeacherMapper.class);

        List<Course> courses = teacherMapper.selectTeachedCourse("T001");
        if( !SqlSessionUtils.getAutoCommit() ) sqlSession.commit();

        System.out.println(courses);
    }

    @Test
    void testSelectOfDepartment() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        TeacherMapper teacherMapper = sqlSession.getMapper(TeacherMapper.class);

        Department teachers = teacherMapper.selectOfDepartment("T001");
        if( !SqlSessionUtils.getAutoCommit() ) sqlSession.commit();

        System.out.println(teachers);
    }
}
