package com.yanisin.sims.model.service.impl;

import com.yanisin.sims.model.bean.Classe;
import com.yanisin.sims.model.bean.Department;
import com.yanisin.sims.model.bean.Student;
import com.yanisin.sims.model.bean.Teacher;
import com.yanisin.sims.model.mapper.DepartmentMapper;
import com.yanisin.sims.model.service.intfa.DepartmentService;
import com.yanisin.sims.model.util.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * @Author: Yanisin
 * @Date: 2023/5/28 20:12
 * @PackageName: com.yanisin.sims.model.service.impl
 * @ClassName: DepartmentServiceImpl
 * @Description: //TODO
 **/

public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentMapper departmentMapper;

    public DepartmentServiceImpl() {
        SqlSessionUtils.setConfigurationPath("MyBatis/mybatis-config.xml");
        SqlSessionUtils.setAutoCommit(true);
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        this.departmentMapper = sqlSession.getMapper(DepartmentMapper.class);
    }

    @Override
    public boolean insertDepartment(Department department) {
        return departmentMapper.insertDepartment(department) > 0;
    }

    @Override
    public boolean updateDepartment(Department department) {
        return departmentMapper.updateDepartment(department) > 0;
    }

    @Override
    public boolean deleteDepartmentById(String departmentId) {
        return departmentMapper.deleteDepartmentById(departmentId) > 0;
    }

    @Override
    public Department getDepartmentById(String departmentId) {
        return departmentMapper.selectDepartmentById(departmentId);
    }

    @Override
    public Department getDepartmentByName(String departmentName) {
        return departmentMapper.selectDepartmentByName(departmentName);
    }

    @Override
    public List<Department> getAllDepartments() {
        return departmentMapper.selectAllDepartment();
    }

    @Override
    public List<Classe> getHasClassesById(String departmentId) {
        return departmentMapper.selectContainClasse(departmentId);
    }

    @Override
    public List<Student> getHasStudentById(String departmentId) {
        return departmentMapper.selectContainStudent(departmentId);
    }

    @Override
    public List<Teacher> getHasTeachersById(String departmentId) {
        return departmentMapper.selectContainTeacher(departmentId);
    }
}
