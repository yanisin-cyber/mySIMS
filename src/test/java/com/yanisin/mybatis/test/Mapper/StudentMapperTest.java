package com.yanisin.mybatis.test.Mapper;

import com.yanisin.sims.model.bean.Classe;
import com.yanisin.sims.model.bean.Course;
import com.yanisin.sims.model.bean.Lesson;
import com.yanisin.sims.model.bean.Student;
import com.yanisin.sims.model.mapper.StudentMapper;
import com.yanisin.sims.model.util.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

import java.util.List;

public class StudentMapperTest {

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
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);


        studentMapper.insertStudent(new Student("S002", "lihua", "男", 20, "C001"));
        if( !SqlSessionUtils.getAutoCommit() ) sqlSession.commit();
    }

    @Test
    void testDelete() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);

        studentMapper.deleteStudentById("S001");
        if( !SqlSessionUtils.getAutoCommit() ) sqlSession.commit();
    }

    @Test
    void testUpdate() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);

        studentMapper.updateStudent(new Student("S002", "lihua", "女", 19, "C001"));
        if( !SqlSessionUtils.getAutoCommit() ) sqlSession.commit();
    }

    @Test
    void testSelectById() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);

        Student student = studentMapper.selectStudentById("S001");
        if( !SqlSessionUtils.getAutoCommit() ) sqlSession.commit();

        System.out.println(student);
    }

    @Test
    void testSelectALL() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);

        List<Student> students = studentMapper.selectAllStudent();
        if( !SqlSessionUtils.getAutoCommit() ) sqlSession.commit();

        System.out.println(students);
    }

    @Test
    void testContainLesson() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);

        List<Lesson> lessons = studentMapper.selectContainLesson("S001");
        if( !SqlSessionUtils.getAutoCommit() ) sqlSession.commit();

        System.out.println(lessons);
    }

    @Test
    void testBelongToClasse() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);

        Classe classe = studentMapper.selectBelongToClasse("S001");
        if( !SqlSessionUtils.getAutoCommit() ) sqlSession.commit();

        System.out.println(classe);
    }
}
