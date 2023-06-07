package com.yanisin.sims.model.service.intfa;

import com.yanisin.sims.model.bean.Lesson;

import java.util.List;

/**
 * @Author: Yanisin
 * @Date: 2023/5/28 15:12
 * @PackageName: com.yanisin.sims.model.service.intfe
 * @IntefaceName: LessonService
 * @Description: //TODO
 **/
public interface LessonService {
    boolean insertLesson(Lesson lesson);
    boolean updateLesson(Lesson lesson);
    boolean deleteLessonByObject(Lesson lesson);
    boolean deleteLessonById(String lessonStuId, String lessonCseId, String lessonTchId);

    Lesson getLessonById(String lessonStuId, String lessonCseId, String lessonTchId);

    List<Lesson> getAllLessons();
}
