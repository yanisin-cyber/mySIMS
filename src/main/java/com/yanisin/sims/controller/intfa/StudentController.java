package com.yanisin.sims.controller.intfa;

import com.yanisin.sims.model.bean.*;

import java.util.List;

/**
 * @Author: Yanisin
 * @Date: 2023/6/3 19:38
 * @PackageName: com.yanisin.sims.controller.intfa
 * @IntefaceName: StudentController
 * @Description: //TODO
 **/
public interface StudentController {
    boolean insertStudent(Student student);
    boolean updateStudent(Student student);
    boolean deleteStudentById(String studentId);

    Student getStudentById(String studentId);

    List<Student> getAllStudents();

    List<Lesson> getSelectedLessonById(String studentId);

    Classe getOfClasseById(String studentId);

    Department getOfDepartmentById(String studentId);
}
