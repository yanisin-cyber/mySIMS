package com.yanisin.sims.model.service.intfa;

import com.yanisin.sims.model.bean.Course;
import com.yanisin.sims.model.bean.Student;
import com.yanisin.sims.model.bean.Teacher;

import java.util.List;

/**
 * @Author: Yanisin
 * @Date: 2023/5/28 15:11
 * @PackageName: com.yanisin.sims.model.service.intfe
 * @IntefaceName: CourseService
 * @Description: //TODO
 **/
public interface CourseService {
    boolean insertCourse(Course course);
    boolean updateCourse(Course course);
    boolean deleteCourseById(String courseId);

    Course getCourseById(String courseId);

    List<Course> getAllCourse();

    List<Student> getSelectUpStudentsById(String courseId);

    Teacher getTeacherById(String courseId);
}
