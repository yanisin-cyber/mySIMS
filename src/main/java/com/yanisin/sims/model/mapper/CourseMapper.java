package com.yanisin.sims.model.mapper;

import com.yanisin.sims.model.bean.Course;
import com.yanisin.sims.model.bean.Student;
import com.yanisin.sims.model.bean.Teacher;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CourseMapper {
    int insertCourse(Course course);
    int updateCourse(Course course);
    int deleteCourseById(@Param("cse_id") String cse_id);

    Course selectCourseById(@Param("cse_id") String cse_id);

    List<Course> selectAllCourse();

    List<Student> selectContainStudent(@Param("cse_id") String cse_id);

    Teacher selectBelongToTeacher(@Param("cse_id") String cse_id);
}
