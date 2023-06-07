package com.yanisin.sims.controller.impl;

import com.yanisin.sims.controller.intfa.CourseController;
import com.yanisin.sims.model.bean.Course;
import com.yanisin.sims.model.bean.Student;
import com.yanisin.sims.model.bean.Teacher;
import com.yanisin.sims.model.service.impl.CourseServiceImpl;
import com.yanisin.sims.model.service.intfa.CourseService;

import java.util.List;

/**
 * @Author: Yanisin
 * @Date: 2023/6/3 20:07
 * @PackageName: com.yanisin.sims.controller.impl
 * @ClassName: CourseControllerImpl
 * @Description: //TODO
 **/
public class CourseControllerImpl implements CourseController {
    private CourseService courseService = new CourseServiceImpl();
    @Override
    public boolean insertCourse(Course course) {
        return courseService.insertCourse(course);
    }

    @Override
    public boolean updateCourse(Course course) {
        return courseService.updateCourse(course);
    }

    @Override
    public boolean deleteCourseById(String courseId) {
        return courseService.deleteCourseById(courseId);
    }

    @Override
    public Course getCourseById(String courseId) {
        return courseService.getCourseById(courseId);
    }

    @Override
    public List<Course> getAllCourse() {
        return courseService.getAllCourse();
    }

    @Override
    public List<Student> getSelectUpStudentsById(String courseId) {
        return courseService.getSelectUpStudentsById(courseId);
    }

    @Override
    public Teacher getTeacherById(String courseId) {
        return courseService.getTeacherById(courseId);
    }
}
