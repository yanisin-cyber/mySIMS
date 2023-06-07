package com.yanisin.sims.controller.impl;

import com.yanisin.sims.controller.intfa.TeacherController;
import com.yanisin.sims.model.bean.*;
import com.yanisin.sims.model.service.impl.TeacherServiceImpl;
import com.yanisin.sims.model.service.intfa.TeacherService;

import java.util.List;

/**
 * @Author: Yanisin
 * @Date: 2023/6/3 19:51
 * @PackageName: com.yanisin.sims.controller.impl
 * @ClassName: TeacherControllerImpl
 * @Description: //TODO
 **/
public class TeacherControllerImpl implements TeacherController {
    private TeacherService teacherService = new TeacherServiceImpl();

    @Override
    public boolean insertTeacher(Teacher teacher) {
        return teacherService.insertTeacher(teacher);
    }

    @Override
    public boolean updateTeacher(Teacher teacher) {
        return teacherService.updateTeacher(teacher);
    }

    @Override
    public boolean deleteTeacherById(String teacherId) {
        return teacherService.deleteTeacherById(teacherId);
    }

    @Override
    public Teacher gerTeacherById(String teacherId) {
        return teacherService.gerTeacherById(teacherId);
    }

    @Override
    public List<Teacher> getAllTeachers() {
        return teacherService.getAllTeachers();
    }

    @Override
    public List<Classe> getManagedClasses(String teacherId) {
        return teacherService.getManagedClasses(teacherId);
    }

    @Override
    public List<Course> getTeachedCourses(String teacherId) {
        return teacherService.getTeachedCourses(teacherId);
    }

    @Override
    public Department gettOfDepartment(String teacherId) {
        return teacherService.gettOfDepartment(teacherId);
    }
}
