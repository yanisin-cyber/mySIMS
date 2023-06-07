package com.yanisin.sims.model.service.impl;

import com.yanisin.sims.model.bean.*;
import com.yanisin.sims.model.mapper.StudentMapper;
import com.yanisin.sims.model.service.intfa.StudentService;
import com.yanisin.sims.model.util.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * @Author: Yanisin
 * @Date: 2023/5/28 20:13
 * @PackageName: com.yanisin.sims.model.service.impl
 * @ClassName: StudentServiceImpl
 * @Description: //TODO
 **/

public class StudentServiceImpl implements StudentService {

    private StudentMapper studentMapper;

    public StudentServiceImpl() {
        SqlSessionUtils.setConfigurationPath("MyBatis/mybatis-config.xml");
        SqlSessionUtils.setAutoCommit(true);
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        this.studentMapper = sqlSession.getMapper(StudentMapper.class);
    };

    @Override
    public boolean insertStudent(Student student) {
        return studentMapper.insertStudent(student) > 0;
    }

    @Override
    public boolean updateStudent(Student student) {
        return studentMapper.updateStudent(student) > 0;
    }

    @Override
    public boolean deleteStudentById(String studentId) {
        return studentMapper.deleteStudentById(studentId) > 0;
    }

    @Override
    public Student getStudentById(String studentId) {
        return studentMapper.selectStudentById(studentId);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentMapper.selectAllStudent();
    }

    @Override
    public List<Lesson> getSelectedLessonById(String studentId) {
        return studentMapper.selectContainLesson(studentId);
    }

    @Override
    public Classe getOfClasseById(String studentId) {
        return studentMapper.selectBelongToClasse(studentId);
    }

    @Override
    public Department getOfDepartmentById(String studentId) {
        return studentMapper.selectBelongToDepartment(studentId);
    }
}
