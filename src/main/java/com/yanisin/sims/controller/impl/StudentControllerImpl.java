package com.yanisin.sims.controller.impl;

import com.yanisin.sims.controller.intfa.StudentController;
import com.yanisin.sims.model.bean.*;
import com.yanisin.sims.model.service.impl.StudentServiceImpl;
import com.yanisin.sims.model.service.intfa.StudentService;

import java.util.List;

/**
 * @Author: Yanisin
 * @Date: 2023/6/3 19:43
 * @PackageName: com.yanisin.sims.controller.impl
 * @ClassName: StudentControllerImpl
 * @Description: //TODO
 **/
public class StudentControllerImpl implements StudentController {
    private StudentService studentService = new StudentServiceImpl();
    @Override
    public boolean insertStudent(Student student) {
        return studentService.insertStudent(student);
    }

    @Override
    public boolean updateStudent(Student student) {
        return studentService.updateStudent(student);
    }

    @Override
    public boolean deleteStudentById(String studentId) {
        return studentService.deleteStudentById(studentId);
    }

    @Override
    public Student getStudentById(String studentId) {
        return studentService.getStudentById(studentId);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @Override
    public List<Lesson> getSelectedLessonById(String studentId) {
        return studentService.getSelectedLessonById(studentId);
    }

    @Override
    public Classe getOfClasseById(String studentId) {
        return studentService.getOfClasseById(studentId);
    }

    @Override
    public Department getOfDepartmentById(String studentId) {
        return studentService.getOfDepartmentById(studentId);
    }
}
