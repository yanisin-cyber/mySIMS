package com.yanisin.sims.model.mapper;

import com.yanisin.sims.model.bean.Classe;
import com.yanisin.sims.model.bean.Department;
import com.yanisin.sims.model.bean.Student;
import com.yanisin.sims.model.bean.Teacher;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DepartmentMapper {
    int insertDepartment(Department department);

    int updateDepartment(Department department);
    int deleteDepartmentById(@Param("dept_id") String dept_id);

    Department selectDepartmentById(@Param("dept_id") String dept_id);
    Department selectDepartmentByName(@Param("dept_name") String dept_name);

    List<Department> selectAllDepartment();

    List<Classe> selectContainClasse(@Param("dept_id") String dept_id);
    List<Teacher> selectContainTeacher(@Param("dept_id") String dept_id);


    // **
    List<Student> selectContainStudent(@Param("dept_id") String dept_id);
}
