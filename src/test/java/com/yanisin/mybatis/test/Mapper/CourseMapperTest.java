package com.yanisin.mybatis.test.Mapper;

import com.yanisin.sims.model.bean.Course;
import com.yanisin.sims.model.bean.Student;
import com.yanisin.sims.model.bean.Teacher;
import com.yanisin.sims.model.mapper.CourseMapper;
import com.yanisin.sims.model.util.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

import java.util.List;

public class CourseMapperTest {

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
        CourseMapper courseMapper = sqlSession.getMapper(CourseMapper.class);

        courseMapper.insertCourse(new Course("CSE002", "数据结构", 4, 4, 2));
        if( !SqlSessionUtils.getAutoCommit() ) sqlSession.commit();
    }

    @Test
    void testDelete() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        CourseMapper courseMapper = sqlSession.getMapper(CourseMapper.class);

        courseMapper.deleteCourseById("CSE002");
        if( !SqlSessionUtils.getAutoCommit() ) sqlSession.commit();
    }

    @Test
    void testUpdate() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        CourseMapper courseMapper = sqlSession.getMapper(CourseMapper.class);

        courseMapper.updateCourse(new Course("CSE002", "数据结构", 4, 4, 2));
        if( !SqlSessionUtils.getAutoCommit() ) sqlSession.commit();
    }

    @Test
    void testSelectById() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        CourseMapper courseMapper = sqlSession.getMapper(CourseMapper.class);

        Course course = courseMapper.selectCourseById("CSE001");
        if( !SqlSessionUtils.getAutoCommit() ) sqlSession.commit();

        System.out.println(course);
    }

    @Test
    void testSelectALL() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        CourseMapper courseMapper = sqlSession.getMapper(CourseMapper.class);

        List<Course> courses = courseMapper.selectAllCourse();
        if( !SqlSessionUtils.getAutoCommit() ) sqlSession.commit();

        System.out.println(courses);
    }

    @Test
    void testSelectContainStudent() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        CourseMapper courseMapper = sqlSession.getMapper(CourseMapper.class);

        List<Student> students = courseMapper.selectContainStudent("CSE001");
        if( !SqlSessionUtils.getAutoCommit() ) sqlSession.commit();

        System.out.println(students);
    }

    @Test
    void testSelectBelongToTeacher() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        CourseMapper courseMapper = sqlSession.getMapper(CourseMapper.class);

        Teacher teacher = courseMapper.selectBelongToTeacher("CSE001");
        if( !SqlSessionUtils.getAutoCommit() ) sqlSession.commit();

        System.out.println(teacher);
    }


}
