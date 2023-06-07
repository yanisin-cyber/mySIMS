package com.yanisin.sims.controller.impl;

import com.yanisin.sims.controller.intfa.DepartmentController;
import com.yanisin.sims.model.bean.Classe;
import com.yanisin.sims.model.bean.Department;
import com.yanisin.sims.model.bean.Student;
import com.yanisin.sims.model.bean.Teacher;
import com.yanisin.sims.model.service.impl.DepartmentServiceImpl;
import com.yanisin.sims.model.service.intfa.DepartmentService;

import java.util.List;

/**
 * @Author: Yanisin
 * @Date: 2023/6/3 19:14
 * @PackageName: com.yanisin.sims.controller.impl
 * @ClassName: DepartmentControllerImpl
 * @Description: //TODO
 **/
public class DepartmentControllerImpl implements DepartmentController {
    private DepartmentService departmentService= new DepartmentServiceImpl();
    @Override
    public boolean insertDepartment(Department department) {
        return departmentService.insertDepartment(department);
    }

    @Override
    public boolean updateDepartment(Department department) {
        return departmentService.updateDepartment(department);
    }

    @Override
    public boolean deleteDepartmentById(String departmentId) {
        return departmentService.deleteDepartmentById(departmentId);
    }

    @Override
    public Department getDepartmentById(String departmentId) {
        return departmentService.getDepartmentById(departmentId);
    }

    @Override
    public Department getDepartmentByName(String departmentName) {
        return departmentService.getDepartmentByName(departmentName);
    }

    @Override
    public List<Department> getAllDepartments() {
        return departmentService.getAllDepartments();
    }

    @Override
    public List<Classe> getHasClassesById(String departmentId) {
        return departmentService.getHasClassesById(departmentId);
    }

    @Override
    public List<Student> getHasStudentById(String departmentId) {
        return departmentService.getHasStudentById(departmentId);
    }

    @Override
    public List<Teacher> getHasTeachersById(String departmentId) {
        return departmentService.getHasTeachersById(departmentId);
    }
}
