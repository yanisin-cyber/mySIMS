package com.yanisin.sims.controller.intfa;

import com.yanisin.sims.model.bean.Course;
import com.yanisin.sims.model.bean.Student;
import com.yanisin.sims.model.bean.Teacher;

import java.util.List;

/**
 * @Author: Yanisin
 * @Date: 2023/6/3 20:06
 * @PackageName: com.yanisin.sims.controller.intfa
 * @IntefaceName: CourseController
 * @Description: //TODO
 **/
public interface CourseController {
    boolean insertCourse(Course course);
    boolean updateCourse(Course course);
    boolean deleteCourseById(String courseId);

    Course getCourseById(String courseId);

    List<Course> getAllCourse();

    List<Student> getSelectUpStudentsById(String courseId);

    Teacher getTeacherById(String courseId);
}
