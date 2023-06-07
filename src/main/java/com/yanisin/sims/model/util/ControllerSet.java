package com.yanisin.sims.model.util;

import com.yanisin.sims.controller.impl.*;
import com.yanisin.sims.controller.intfa.*;

/**
 * @Author: Yanisin
 * @Date: 2023/6/7 22:23
 * @PackageName: com.yanisin.sims.model.util
 * @ClassName: ControllerSet
 * @Description: //TODO
 **/
public class ControllerSet {
    private DepartmentController departmentController;
    private ClasseController classeController;
    private TeacherController teacherController;
    private StudentController studentController;
    private CourseController courseController;
    private LessonController lessonController;

    private UserController userController;

    public DepartmentController getDepartmentController() {
        return departmentController;
    }

    public ClasseController getClasseController() {
        return classeController;
    }

    public TeacherController getTeacherController() {
        return teacherController;
    }

    public StudentController getStudentController() {
        return studentController;
    }

    public CourseController getCourseController() {
        return courseController;
    }

    public LessonController getLessonController() {
        return lessonController;
    }

    public UserController getUserController() {
        return userController;
    }

    public ControllerSet() {
        departmentController = new DepartmentControllerImpl();
        classeController = new ClasseControllerImpl();
        teacherController = new TeacherControllerImpl();
        studentController = new StudentControllerImpl();
        courseController = new CourseControllerImpl();
        lessonController = new LessonControllerImpl();
        userController = new UserControllerImpl();
    }
}
