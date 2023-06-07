package com.yanisin.sims.controller.intfa;

import com.yanisin.sims.model.bean.Classe;
import com.yanisin.sims.model.bean.Department;
import com.yanisin.sims.model.bean.Student;
import com.yanisin.sims.model.bean.Teacher;

import java.util.List;

/**
 * @Author: Yanisin
 * @Date: 2023/6/3 19:13
 * @PackageName: com.yanisin.sims.controller.intfa
 * @IntefaceName: DepartmentController
 * @Description: //TODO
 **/
public interface DepartmentController {
    boolean insertDepartment(Department department);
    boolean updateDepartment(Department department);
    boolean deleteDepartmentById(String departmentId);

    Department getDepartmentById(String departmentId);
    Department getDepartmentByName(String departmentName);

    List<Department> getAllDepartments();

    List<Classe> getHasClassesById(String departmentId);

    List<Student> getHasStudentById(String departmentId);

    List<Teacher> getHasTeachersById(String departmentId);
}
