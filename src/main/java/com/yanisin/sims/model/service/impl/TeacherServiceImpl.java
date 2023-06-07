package com.yanisin.sims.model.service.impl;

import com.yanisin.sims.model.bean.Classe;
import com.yanisin.sims.model.bean.Course;
import com.yanisin.sims.model.bean.Department;
import com.yanisin.sims.model.bean.Teacher;
import com.yanisin.sims.model.mapper.TeacherMapper;
import com.yanisin.sims.model.service.intfa.TeacherService;
import com.yanisin.sims.model.util.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * @Author: Yanisin
 * @Date: 2023/5/28 20:14
 * @PackageName: com.yanisin.sims.model.service.impl
 * @ClassName: TeacherServiceImpl
 * @Description: //TODO
 **/

public class TeacherServiceImpl implements TeacherService {

    private TeacherMapper teacherMapper;

    public TeacherServiceImpl() {
        SqlSessionUtils.setConfigurationPath("MyBatis/mybatis-config.xml");
        SqlSessionUtils.setAutoCommit(true);
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        this.teacherMapper = sqlSession.getMapper(TeacherMapper.class);
    };

    @Override
    public boolean insertTeacher(Teacher teacher) {
        return teacherMapper.insertTeacher(teacher) > 0;
    }

    @Override
    public boolean updateTeacher(Teacher teacher) {
        return teacherMapper.updateTeacher(teacher) > 0;
    }

    @Override
    public boolean deleteTeacherById(String teacherId) {
        return teacherMapper.deleteTeacherById(teacherId) > 0;
    }

    @Override
    public Teacher gerTeacherById(String teacherId) {
        return teacherMapper.selectTeacherById(teacherId);
    }

    @Override
    public List<Teacher> getAllTeachers() {
        return teacherMapper.selectAllTeacher();
    }

    @Override
    public List<Classe> getManagedClasses(String teacherId) {
        return teacherMapper.selectManagedClasse(teacherId);
    }

    @Override
    public List<Course> getTeachedCourses(String teacherId) {
        return teacherMapper.selectTeachedCourse(teacherId);
    }

    @Override
    public Department gettOfDepartment(String teacherId) {
        return teacherMapper.selectOfDepartment(teacherId);
    }
}
