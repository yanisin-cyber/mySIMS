package com.yanisin.sims.model.mapper;

import com.yanisin.sims.model.bean.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface StudentMapper {
    int insertStudent(Student student);
    int updateStudent(Student student);
    int deleteStudentById(@Param("stu_id") String stu_id);

    Student selectStudentById(@Param("stu_id") String stu_id);

    List<Student> selectAllStudent();

    List<Lesson> selectContainLesson(@Param("stu_id") String stu_id);

    Classe selectBelongToClasse(@Param("stu_id") String stu_id);

    // *
    Department selectBelongToDepartment(@Param("stu_id") String stu_id);
}
