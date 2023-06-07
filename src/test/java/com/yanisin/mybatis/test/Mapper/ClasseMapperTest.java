package com.yanisin.mybatis.test.Mapper;

import com.yanisin.sims.model.bean.Classe;
import com.yanisin.sims.model.bean.Department;
import com.yanisin.sims.model.bean.Student;
import com.yanisin.sims.model.bean.Teacher;
import com.yanisin.sims.model.mapper.ClasseMapper;
import com.yanisin.sims.model.util.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ClasseMapperTest {

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
        ClasseMapper classeMapper = sqlSession.getMapper(ClasseMapper.class);

        classeMapper.insertClasse(new Classe("C003", "网络工程", "D001", "T001"));
        if( !SqlSessionUtils.getAutoCommit() ) sqlSession.commit();
    }

    @Test
    void testDelete() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ClasseMapper classeMapper = sqlSession.getMapper(ClasseMapper.class);

        classeMapper.deleteClasseById("C001");
        if( !SqlSessionUtils.getAutoCommit() ) sqlSession.commit();
    }

    @Test
    void testUpdate() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ClasseMapper classeMapper = sqlSession.getMapper(ClasseMapper.class);

        classeMapper.updateClasse(new Classe("C003", "网络工程", "D001", "T002"));
        if( !SqlSessionUtils.getAutoCommit() ) sqlSession.commit();
    }

    @Test
    void testSelectById() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ClasseMapper classeMapper = sqlSession.getMapper(ClasseMapper.class);

        Classe classe = classeMapper.selectClasseById("C001");
        if( !SqlSessionUtils.getAutoCommit() ) sqlSession.commit();

        System.out.println(classe);
    }

    @Test
    void testSelectALL() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ClasseMapper classeMapper = sqlSession.getMapper(ClasseMapper.class);

        List<Classe> classes = classeMapper.selectAllClasse();
        if( !SqlSessionUtils.getAutoCommit() ) sqlSession.commit();

        System.out.println(classes);
    }

    @Test
    void testSelectContainStudent() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ClasseMapper classeMapper = sqlSession.getMapper(ClasseMapper.class);

        List<Student> students = classeMapper.selectContainStudent("C002");
        if( !SqlSessionUtils.getAutoCommit() ) sqlSession.commit();

        System.out.println(students);
    }

    @Test
    void testSelectContainTeacher() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ClasseMapper classeMapper = sqlSession.getMapper(ClasseMapper.class);

        List<Teacher> teachers = classeMapper.selectContainTeacher("C001");
        if( !SqlSessionUtils.getAutoCommit() ) sqlSession.commit();

        System.out.println(teachers);
    }

    @Test
    void testSelectBelongToDepartment() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ClasseMapper classeMapper = sqlSession.getMapper(ClasseMapper.class);

        Department department = classeMapper.selectBelongToDepartment("C001");
        if( !SqlSessionUtils.getAutoCommit() ) sqlSession.commit();

        System.out.println(department);
    }
}
