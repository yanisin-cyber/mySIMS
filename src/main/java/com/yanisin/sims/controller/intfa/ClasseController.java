package com.yanisin.sims.controller.intfa;

import com.yanisin.sims.model.bean.Classe;
import com.yanisin.sims.model.bean.Department;
import com.yanisin.sims.model.bean.Student;
import com.yanisin.sims.model.bean.Teacher;

import java.util.List;

/**
 * @Author: Yanisin
 * @Date: 2023/6/3 19:28
 * @PackageName: com.yanisin.sims.controller.intfa
 * @IntefaceName: ClasseController
 * @Description: //TODO
 **/
public interface ClasseController {
    boolean insertClasse(Classe classe);
    boolean updateClasse(Classe classe);
    boolean deleteClasseById(String classId);

    Classe getClasseById(String classId);

    List<Classe> getAllClasses();

    List<Student> getHasStudentsById(String classId);

    List<Teacher> getManaTeacherById(String classId);

    Department getOfDepartmentsById(String classId);
}
