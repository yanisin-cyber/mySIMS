package com.yanisin.sims.model.mapper;

import com.yanisin.sims.model.bean.Classe;
import com.yanisin.sims.model.bean.Department;
import com.yanisin.sims.model.bean.Student;
import com.yanisin.sims.model.bean.Teacher;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ClasseMapper {
    int insertClasse(Classe classe);
    int updateClasse(Classe classe);
    int deleteClasseById(@Param("class_id") String class_id);

    Classe selectClasseById(@Param("class_id") String class_id);

    List<Classe> selectAllClasse();

    List<Student> selectContainStudent(@Param("class_id") String class_id);

    List<Teacher> selectContainTeacher(@Param("class_id") String class_id);

    Department selectBelongToDepartment(@Param("class_id") String class_id);
}
