package com.yanisin.sims.controller.impl;

import com.yanisin.sims.controller.intfa.LessonController;
import com.yanisin.sims.model.bean.Lesson;
import com.yanisin.sims.model.service.impl.LessonServiceImpl;
import com.yanisin.sims.model.service.intfa.LessonService;

import java.util.List;

/**
 * @Author: Yanisin
 * @Date: 2023/6/3 20:12
 * @PackageName: com.yanisin.sims.controller.impl
 * @ClassName: LessonControllerImpl
 * @Description: //TODO
 **/
public class LessonControllerImpl implements LessonController {
    private LessonService lessonService = new LessonServiceImpl();
    @Override
    public boolean insertLesson(Lesson lesson) {
        return lessonService.insertLesson(lesson);
    }

    @Override
    public boolean updateLesson(Lesson lesson) {
        return lessonService.updateLesson(lesson);
    }

    @Override
    public boolean deleteLessonByObject(Lesson lesson) {
        return lessonService.deleteLessonByObject(lesson);
    }

    @Override
    public boolean deleteLessonById(String lessonStuId, String lessonCseId, String lessonTchId) {
        return lessonService.deleteLessonById(lessonStuId, lessonCseId, lessonTchId);
    }

    @Override
    public Lesson getLessonById(String lessonStuId, String lessonCseId, String lessonTchId) {
        return lessonService.getLessonById(lessonStuId, lessonCseId, lessonTchId);
    }

    @Override
    public List<Lesson> getAllLessons() {
        return lessonService.getAllLessons();
    }
}
