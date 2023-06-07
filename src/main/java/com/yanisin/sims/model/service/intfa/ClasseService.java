package com.yanisin.sims.model.service.intfa;

import com.yanisin.sims.model.bean.Classe;
import com.yanisin.sims.model.bean.Department;
import com.yanisin.sims.model.bean.Student;
import com.yanisin.sims.model.bean.Teacher;

import java.util.List;

/**
 * @Author: Yanisin
 * @Date: 2023/5/28 15:11
 * @PackageName: com.yanisin.sims.model.service.intfe
 * @IntefaceName: ClasseService
 * @Description: //TODO
 **/
public interface ClasseService {
    boolean insertClasse(Classe classe);
    boolean updateClasse(Classe classe);
    boolean deleteClasseById(String classId);

    Classe getClasseById(String classId);

    List<Classe> getAllClasses();

    List<Student> getHasStudentsById(String classId);

    List<Teacher> getManaTeacherById(String classId);

    Department getOfDepartmentsById(String classId);
}
