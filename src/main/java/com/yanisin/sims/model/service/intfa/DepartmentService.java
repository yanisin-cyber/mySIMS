package com.yanisin.sims.model.service.intfa;

import com.yanisin.sims.model.bean.Classe;
import com.yanisin.sims.model.bean.Department;
import com.yanisin.sims.model.bean.Student;
import com.yanisin.sims.model.bean.Teacher;

import java.util.List;

/**
 * @Author: Yanisin
 * @Date: 2023/5/28 15:12
 * @PackageName: com.yanisin.sims.model.service.intfe
 * @IntefaceName: DepartmentService
 * @Description: //TODO
 **/
public interface DepartmentService {
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
