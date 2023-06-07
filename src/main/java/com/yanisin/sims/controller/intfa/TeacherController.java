package com.yanisin.sims.controller.intfa;

import com.yanisin.sims.model.bean.*;

import java.util.List;

/**
 * @Author: Yanisin
 * @Date: 2023/6/3 19:50
 * @PackageName: com.yanisin.sims.controller.intfa
 * @IntefaceName: TeacherController
 * @Description: //TODO
 **/
public interface TeacherController {
    boolean insertTeacher(Teacher teacher);

    boolean updateTeacher(Teacher teacher);
    boolean deleteTeacherById(String teacherId);

    Teacher gerTeacherById(String teacherId);

    List<Teacher> getAllTeachers();

    List<Classe> getManagedClasses(String teacherId);

    List<Course> getTeachedCourses(String teacherId);

    Department gettOfDepartment(String teacherId);
}
