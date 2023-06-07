package com.yanisin.sims.model.mapper;

import com.yanisin.sims.model.bean.Lesson;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface LessonMapper {
    int insertLesson(Lesson lesson);
    int updateLesson(Lesson lesson);
    int deleteLessonById(@Param("les_stu_id") String les_stu_id,
                          @Param("les_cse_id") String les_cse_id,
                          @Param("les_tch_id") String les_tch_id);

    Lesson selectLessonById(@Param("les_stu_id") String les_stu_id,
                            @Param("les_cse_id") String les_cse_id,
                            @Param("les_tch_id") String les_tch_id);

    List<Lesson> selectAllLesson();
}
