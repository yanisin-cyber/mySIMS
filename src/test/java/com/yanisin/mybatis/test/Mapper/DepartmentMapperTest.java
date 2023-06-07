package com.yanisin.mybatis.test.Mapper;

import com.yanisin.sims.model.bean.Classe;
import com.yanisin.sims.model.bean.Department;
import com.yanisin.sims.model.bean.Teacher;
import com.yanisin.sims.model.mapper.DepartmentMapper;
import com.yanisin.sims.model.util.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

import java.util.List;


public class DepartmentMapperTest {

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
        DepartmentMapper departmentMapper = sqlSession.getMapper(DepartmentMapper.class);

        departmentMapper.insertDepartment(new Department("D003", "哲学系", "东南校区"));
        if( !SqlSessionUtils.getAutoCommit() ) sqlSession.commit();
    }

    @Test
    void testDelete() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DepartmentMapper departmentMapper = sqlSession.getMapper(DepartmentMapper.class);

        departmentMapper.deleteDepartmentById("D001");
        if( !SqlSessionUtils.getAutoCommit() ) sqlSession.commit();
    }

    @Test
    void testUpdate() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DepartmentMapper departmentMapper = sqlSession.getMapper(DepartmentMapper.class);

        departmentMapper.updateDepartment(new Department("D003", "哲学系", "东湖校区"));
        if( !SqlSessionUtils.getAutoCommit() ) sqlSession.commit();
    }

    @Test
    void testSelectById() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DepartmentMapper departmentMapper = sqlSession.getMapper(DepartmentMapper.class);

        Department department = departmentMapper.selectDepartmentById("D001");
        if( !SqlSessionUtils.getAutoCommit() ) sqlSession.commit();

        System.out.println(department);
    }

    @Test
    void testSelectByName() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DepartmentMapper departmentMapper = sqlSession.getMapper(DepartmentMapper.class);

        Department department = departmentMapper.selectDepartmentByName("计算机系");
        if( !SqlSessionUtils.getAutoCommit() ) sqlSession.commit();

        System.out.println(department);
    }

    @Test
    void testSelectALL() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DepartmentMapper departmentMapper = sqlSession.getMapper(DepartmentMapper.class);

        List<Department> departments = departmentMapper.selectAllDepartment();
        if( !SqlSessionUtils.getAutoCommit() ) sqlSession.commit();

        System.out.println(departments);
    }

    @Test
    void testSelectContainClases() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DepartmentMapper departmentMapper = sqlSession.getMapper(DepartmentMapper.class);

        List<Classe> classes = departmentMapper.selectContainClasse("D001");
        if( !SqlSessionUtils.getAutoCommit() ) sqlSession.commit();

        System.out.println(classes);
    }

    @Test
    void testSelectContainTeacher() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DepartmentMapper departmentMapper = sqlSession.getMapper(DepartmentMapper.class);

        List<Teacher> teachers = departmentMapper.selectContainTeacher("D001");
        if( !SqlSessionUtils.getAutoCommit() ) sqlSession.commit();

        System.out.println(teachers);
    }
}
