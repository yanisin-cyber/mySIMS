package com.yanisin.sims.model.bean;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Lesson {
    private SimpleStringProperty les_stu_id;
    private SimpleStringProperty les_cse_id;
    private SimpleStringProperty les_tch_id;
    private SimpleIntegerProperty les_grade;

    public Lesson() {
        this("", "", "", 0);
    }

    public Lesson(String les_stu_id, String les_cse_id, String les_tch_id, int les_grade) {
        this.les_stu_id = new SimpleStringProperty(les_stu_id);
        this.les_cse_id = new SimpleStringProperty(les_cse_id);
        this.les_tch_id = new SimpleStringProperty(les_tch_id);
        this.les_grade = new SimpleIntegerProperty(les_grade);
    }

    public String getLes_stu_id() {
        return les_stu_id.get();
    }

    public SimpleStringProperty les_stu_idProperty() {
        return les_stu_id;
    }

    public void setLes_stu_id(String les_stu_id) {
        this.les_stu_id.set(les_stu_id);
    }

    public String getLes_cse_id() {
        return les_cse_id.get();
    }

    public SimpleStringProperty les_cse_idProperty() {
        return les_cse_id;
    }

    public void setLes_cse_id(String les_cse_id) {
        this.les_cse_id.set(les_cse_id);
    }

    public String getLes_tch_id() {
        return les_tch_id.get();
    }

    public SimpleStringProperty les_tch_idProperty() {
        return les_tch_id;
    }

    public void setLes_tch_id(String les_tch_id) {
        this.les_tch_id.set(les_tch_id);
    }

    public int getLes_grade() {
        return les_grade.get();
    }

    public SimpleIntegerProperty les_gradeProperty() {
        return les_grade;
    }

    public void setLes_grade(int les_grade) {
        this.les_grade.set(les_grade);
    }

    @Override
    public String toString() {
        return "Lesson{" +
                "les_stu_id='" + les_stu_id.get() + '\'' +
                ", les_cse_id='" + les_cse_id.get() + '\'' +
                ", les_tch_id='" + les_tch_id.get() + '\'' +
                ", les_grade=" + les_grade.get() +
                '}';
    }
}