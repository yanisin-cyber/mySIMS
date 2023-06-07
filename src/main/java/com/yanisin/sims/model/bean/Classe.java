package com.yanisin.sims.model.bean;

import javafx.beans.property.SimpleStringProperty;

public class Classe {
    private SimpleStringProperty class_id;
    private SimpleStringProperty class_subject;
    private SimpleStringProperty class_dept_id;
    private SimpleStringProperty class_manager_tch_id;

    public Classe() {
        this("", "", "", "");
    }

    public Classe(String class_id, String class_subject, String class_dept_id, String class_manager_tch_id) {
        this.class_id = new SimpleStringProperty(class_id);
        this.class_subject = new SimpleStringProperty(class_subject);
        this.class_dept_id = new SimpleStringProperty(class_dept_id);
        this.class_manager_tch_id = new SimpleStringProperty(class_manager_tch_id);
    }

    public String getClass_id() {
        return class_id.get();
    }

    public SimpleStringProperty class_idProperty() {
        return class_id;
    }

    public void setClass_id(String class_id) {
        this.class_id.set(class_id);
    }

    public String getClass_subject() {
        return class_subject.get();
    }

    public SimpleStringProperty class_subjectProperty() {
        return class_subject;
    }

    public void setClass_subject(String class_subject) {
        this.class_subject.set(class_subject);
    }

    public String getClass_dept_id() {
        return class_dept_id.get();
    }

    public SimpleStringProperty class_dept_idProperty() {
        return class_dept_id;
    }

    public void setClass_dept_id(String class_dept_id) {
        this.class_dept_id.set(class_dept_id);
    }

    public String getClass_manager_tch_id() {
        return class_manager_tch_id.get();
    }

    public SimpleStringProperty class_manager_tch_idProperty() {
        return class_manager_tch_id;
    }

    public void setClass_manager_tch_id(String class_manager_tch_id) {
        this.class_manager_tch_id.set(class_manager_tch_id);
    }

    @Override
    public String toString() {
        return class_id.get();
    }
}