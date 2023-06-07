package com.yanisin.sims.model.service.impl;

import com.yanisin.sims.model.bean.Lesson;
import com.yanisin.sims.model.mapper.LessonMapper;
import com.yanisin.sims.model.service.intfa.LessonService;
import com.yanisin.sims.model.util.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * @Author: Yanisin
 * @Date: 2023/5/28 20:12
 * @PackageName: com.yanisin.sims.model.service.impl
 * @ClassName: LessonServiceImpl
 * @Description: //TODO
 **/

public class LessonServiceImpl implements LessonService {

    private LessonMapper lessonMapper;

    public LessonServiceImpl() {
        SqlSessionUtils.setConfigurationPath("MyBatis/mybatis-config.xml");
        SqlSessionUtils.setAutoCommit(true);
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        this.lessonMapper = sqlSession.getMapper(LessonMapper.class);
    }

    @Override
    public boolean insertLesson(Lesson lesson) {
        return lessonMapper.insertLesson(lesson) > 0;
    }

    @Override
    public boolean updateLesson(Lesson lesson) {
        return lessonMapper.updateLesson(lesson) > 0;
    }

    @Override
    public boolean deleteLessonByObject(Lesson lesson) {
        return lessonMapper.deleteLessonById(lesson.getLes_stu_id(), lesson.getLes_cse_id(), lesson.getLes_tch_id()) > 0;
    }

    @Override
    public boolean deleteLessonById(String lessonStuId, String lessonCseId, String lessonTchId) {
        return lessonMapper.deleteLessonById(lessonStuId, lessonCseId, lessonTchId) > 0;
    }

    @Override
    public Lesson getLessonById(String lessonStuId, String lessonCseId, String lessonTchId) {
        return lessonMapper.selectLessonById(lessonStuId, lessonCseId, lessonTchId);
    }

    @Override
    public List<Lesson> getAllLessons() {
        return lessonMapper.selectAllLesson();
    }
}
