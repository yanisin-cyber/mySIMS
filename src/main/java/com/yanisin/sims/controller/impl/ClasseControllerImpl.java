package com.yanisin.sims.controller.impl;

import com.yanisin.sims.controller.intfa.ClasseController;
import com.yanisin.sims.model.bean.Classe;
import com.yanisin.sims.model.bean.Department;
import com.yanisin.sims.model.bean.Student;
import com.yanisin.sims.model.bean.Teacher;
import com.yanisin.sims.model.service.impl.ClasseServiceImpl;
import com.yanisin.sims.model.service.intfa.ClasseService;

import java.util.List;

/**
 * @Author: Yanisin
 * @Date: 2023/6/3 19:29
 * @PackageName: com.yanisin.sims.controller.impl
 * @ClassName: ClasseControllerImpl
 * @Description: //TODO
 **/
public class ClasseControllerImpl implements ClasseController {
    ClasseService classeService = new ClasseServiceImpl();
    @Override
    public boolean insertClasse(Classe classe) {
        return classeService.insertClasse(classe);
    }

    @Override
    public boolean updateClasse(Classe classe) {
        return classeService.updateClasse(classe);
    }

    @Override
    public boolean deleteClasseById(String classId) {
        return classeService.deleteClasseById(classId);
    }

    @Override
    public Classe getClasseById(String classId) {
        return classeService.getClasseById(classId);
    }

    @Override
    public List<Classe> getAllClasses() {
        return classeService.getAllClasses();
    }

    @Override
    public List<Student> getHasStudentsById(String classId) {
        return classeService.getHasStudentsById(classId);
    }

    @Override
    public List<Teacher> getManaTeacherById(String classId) {
        return classeService.getManaTeacherById(classId);
    }

    @Override
    public Department getOfDepartmentsById(String classId) {
        return classeService.getOfDepartmentsById(classId);
    }
}
