package com.yanisin.sims.model.service.intfa;

import com.yanisin.sims.model.bean.*;


import java.util.List;

/**
 * @Author: Yanisin
 * @Date: 2023/5/28 15:12
 * @PackageName: com.yanisin.sims.model.service.intfe
 * @IntefaceName: StudentService
 * @Description: //TODO
 **/
public interface StudentService {
    boolean insertStudent(Student student);
    boolean updateStudent(Student student);
    boolean deleteStudentById(String studentId);

    Student getStudentById(String studentId);

    List<Student> getAllStudents();

    List<Lesson> getSelectedLessonById(String studentId);

    Classe getOfClasseById(String studentId);

    Department getOfDepartmentById(String studentId);
}
