package com.yanisin.sims.model.mapper;

import com.yanisin.sims.model.bean.Classe;
import com.yanisin.sims.model.bean.Course;
import com.yanisin.sims.model.bean.Department;
import com.yanisin.sims.model.bean.Teacher;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TeacherMapper {
    int insertTeacher(Teacher teacher);

    int updateTeacher(Teacher teacher);
    int deleteTeacherById(@Param("tch_id") String tch_id);

    Teacher selectTeacherById(@Param("tch_id") String tch_id);

    List<Teacher> selectAllTeacher();

    List<Classe> selectManagedClasse(@Param("tch_id") String tch_id);

    List<Course> selectTeachedCourse(@Param("tch_id") String tch_id);

    Department selectOfDepartment(@Param("tch_id") String tch_id);
}
