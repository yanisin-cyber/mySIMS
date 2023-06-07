package com.yanisin.sims.model.service.impl;

import com.yanisin.sims.model.bean.Course;
import com.yanisin.sims.model.bean.Student;
import com.yanisin.sims.model.bean.Teacher;
import com.yanisin.sims.model.mapper.CourseMapper;
import com.yanisin.sims.model.service.intfa.CourseService;
import com.yanisin.sims.model.util.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * @Author: Yanisin
 * @Date: 2023/5/28 20:11
 * @PackageName: com.yanisin.sims.model.service.impl
 * @ClassName: CourseServiceImpl
 * @Description: //TODO
 **/

public class CourseServiceImpl implements CourseService {

    private CourseMapper courseMapper;

    public CourseServiceImpl() {
        SqlSessionUtils.setConfigurationPath("MyBatis/mybatis-config.xml");
        SqlSessionUtils.setAutoCommit(true);
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        this.courseMapper = sqlSession.getMapper(CourseMapper.class);
    }

    @Override
    public boolean insertCourse(Course course) {
        return courseMapper.insertCourse(course) > 0;
    }

    @Override
    public boolean updateCourse(Course course) {
        return courseMapper.updateCourse(course) > 0;
    }

    @Override
    public boolean deleteCourseById(String courseId) {
        return courseMapper.deleteCourseById(courseId) > 0;
    }

    @Override
    public Course getCourseById(String courseId) {
        return courseMapper.selectCourseById(courseId);
    }

    @Override
    public List<Course> getAllCourse() {
        return courseMapper.selectAllCourse();
    }

    @Override
    public List<Student> getSelectUpStudentsById(String courseId) {
        return courseMapper.selectContainStudent(courseId);
    }

    @Override
    public Teacher getTeacherById(String courseId) {
        return courseMapper.selectBelongToTeacher(courseId);
    }
}
