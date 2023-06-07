package com.yanisin.sims.model.service.impl;

import com.yanisin.sims.model.bean.Classe;
import com.yanisin.sims.model.bean.Department;
import com.yanisin.sims.model.bean.Student;
import com.yanisin.sims.model.bean.Teacher;
import com.yanisin.sims.model.mapper.ClasseMapper;
import com.yanisin.sims.model.service.intfa.ClasseService;
import com.yanisin.sims.model.util.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;


import java.util.List;

/**
 * @Author: Yanisin
 * @Date: 2023/5/28 20:10
 * @PackageName: com.yanisin.sims.model.service.impl
 * @ClassName: ClasseServiceImpl
 * @Description: //TODO
 **/

public class ClasseServiceImpl implements ClasseService {

    private ClasseMapper classeMapper;

    public ClasseServiceImpl() {
        SqlSessionUtils.setConfigurationPath("MyBatis/mybatis-config.xml");
        SqlSessionUtils.setAutoCommit(true);
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        this.classeMapper = sqlSession.getMapper(ClasseMapper.class);
    }


    @Override
    public boolean insertClasse(Classe classe) {
        return classeMapper.insertClasse(classe) > 0;
    }

    @Override
    public boolean updateClasse(Classe classe) {
        return classeMapper.updateClasse(classe) > 0;
    }

    @Override
    public boolean deleteClasseById(String classId) {
        return classeMapper.deleteClasseById(classId) > 0;
    }

    @Override
    public Classe getClasseById(String classId) {
        return classeMapper.selectClasseById(classId);
    }

    @Override
    public List<Classe> getAllClasses() {
        return classeMapper.selectAllClasse();
    }

    @Override
    public List<Student> getHasStudentsById(String classId) {
        return classeMapper.selectContainStudent(classId);
    }

    @Override
    public List<Teacher> getManaTeacherById(String classId) {
        return classeMapper.selectContainTeacher(classId);
    }

    @Override
    public Department getOfDepartmentsById(String classId) {
        return classeMapper.selectBelongToDepartment(classId);
    }
}
