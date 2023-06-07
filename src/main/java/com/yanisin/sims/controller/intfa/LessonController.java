package com.yanisin.sims.controller.intfa;

import com.yanisin.sims.model.bean.Lesson;

import java.util.List;

/**
 * @Author: Yanisin
 * @Date: 2023/6/3 20:10
 * @PackageName: com.yanisin.sims.controller.intfa
 * @IntefaceName: LessonController
 * @Description: //TODO
 **/
public interface LessonController {
    boolean insertLesson(Lesson lesson);
    boolean updateLesson(Lesson lesson);
    boolean deleteLessonByObject(Lesson lesson);
    boolean deleteLessonById(String lessonStuId, String lessonCseId, String lessonTchId);

    Lesson getLessonById(String lessonStuId, String lessonCseId, String lessonTchId);

    List<Lesson> getAllLessons();
}
