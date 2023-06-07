package com.yanisin.sims.model.bean;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Student {
    private SimpleStringProperty stu_id;
    private SimpleStringProperty stu_name;
    private SimpleStringProperty stu_sex;
    private SimpleIntegerProperty stu_age;
    private SimpleStringProperty stu_class_id;

    public Student() {
        this("", "", "", 0, "");
    }

    public Student(String stu_id, String stu_name, String stu_sex, int stu_age, String stu_class_id) {
        this.stu_id = new SimpleStringProperty(stu_id);
        this.stu_name = new SimpleStringProperty(stu_name);
        this.stu_sex = new SimpleStringProperty(stu_sex);
        this.stu_age = new SimpleIntegerProperty(stu_age);
        this.stu_class_id = new SimpleStringProperty(stu_class_id);
    }

    public String getStu_id() {
        return stu_id.get();
    }

    public SimpleStringProperty stu_idProperty() {
        return stu_id;
    }

    public void setStu_id(String stu_id) {
        this.stu_id.set(stu_id);
    }

    public String getStu_name() {
        return stu_name.get();
    }

    public SimpleStringProperty stu_nameProperty() {
        return stu_name;
    }

    public void setStu_name(String stu_name) {
        this.stu_name.set(stu_name);
    }

    public String getStu_sex() {
        return stu_sex.get();
    }

    public SimpleStringProperty stu_sexProperty() {
        return stu_sex;
    }

    public void setStu_sex(String stu_sex) {
        this.stu_sex.set(stu_sex);
    }

    public int getStu_age() {
        return stu_age.get();
    }

    public SimpleIntegerProperty stu_ageProperty() {
        return stu_age;
    }

    public void setStu_age(int stu_age) {
        this.stu_age.set(stu_age);
    }

    public String getStu_class_id() {
        return stu_class_id.get();
    }

    public SimpleStringProperty stu_class_idProperty() {
        return stu_class_id;
    }

    public void setStu_class_id(String stu_class_id) {
        this.stu_class_id.set(stu_class_id);
    }

    @Override
    public String toString() {
        return "Student{" +
                "stu_id='" + stu_id.get() + '\'' +
                ", stu_name='" + stu_name.get() + '\'' +
                ", stu_sex='" + stu_sex.get() + '\'' +
                ", stu_age='" + stu_age.get() + '\'' +
                ", stu_class_id='" + stu_class_id.get() + '\'' +
                '}';
    }
}