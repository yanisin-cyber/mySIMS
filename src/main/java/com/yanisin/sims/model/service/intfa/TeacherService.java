package com.yanisin.sims.model.service.intfa;

import com.yanisin.sims.model.bean.Classe;
import com.yanisin.sims.model.bean.Course;
import com.yanisin.sims.model.bean.Department;
import com.yanisin.sims.model.bean.Teacher;

import java.util.List;

/**
 * @Author: Yanisin
 * @Date: 2023/5/28 15:52
 * @PackageName: com.yanisin.sims.model.service.intfe
 * @IntefaceName: TeacherService
 * @Description: //TODO
 **/
public interface TeacherService {
    boolean insertTeacher(Teacher teacher);

    boolean updateTeacher(Teacher teacher);
    boolean deleteTeacherById(String teacherId);

    Teacher gerTeacherById(String teacherId);

    List<Teacher> getAllTeachers();

    List<Classe> getManagedClasses(String teacherId);

    List<Course> getTeachedCourses(String teacherId);

    Department gettOfDepartment(String teacherId);
}
