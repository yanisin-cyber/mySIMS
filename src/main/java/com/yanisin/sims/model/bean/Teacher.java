package com.yanisin.sims.model.bean;

import javafx.beans.property.SimpleStringProperty;

public class Teacher {
    private SimpleStringProperty tch_id;
    private SimpleStringProperty tch_name;
    private SimpleStringProperty tch_tittle;
    private SimpleStringProperty tch_dept_id;

    public Teacher() {
        this("", "", "", "");
    }

    public Teacher(String tch_id, String tch_name, String tch_tittle, String tch_dept_id) {
        this.tch_id = new SimpleStringProperty(tch_id);
        this.tch_name = new SimpleStringProperty(tch_name);
        this.tch_tittle = new SimpleStringProperty(tch_tittle);
        this.tch_dept_id = new SimpleStringProperty(tch_dept_id);
    }

    public String getTch_id() {
        return tch_id.get();
    }

    public SimpleStringProperty tch_idProperty() {
        return tch_id;
    }

    public void setTch_id(String tch_id) {
        this.tch_id.set(tch_id);
    }

    public String getTch_name() {
        return tch_name.get();
    }

    public SimpleStringProperty tch_nameProperty() {
        return tch_name;
    }

    public void setTch_name(String tch_name) {
        this.tch_name.set(tch_name);
    }

    public String getTch_tittle() {
        return tch_tittle.get();
    }

    public SimpleStringProperty tch_tittleProperty() {
        return tch_tittle;
    }

    public void setTch_tittle(String tch_tittle) {
        this.tch_tittle.set(tch_tittle);
    }

    public String getTch_dept_id() {
        return tch_dept_id.get();
    }

    public SimpleStringProperty tch_dept_idProperty() {
        return tch_dept_id;
    }

    public void setTch_dept_id(String tch_dept_id) {
        this.tch_dept_id.set(tch_dept_id);
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "tch_id='" + tch_id.get() + '\'' +
                ", tch_name='" + tch_name.get() + '\'' +
                ", tch_tittle='" + tch_tittle.get() + '\'' +
                ", tch_dept_id='" + tch_dept_id.get() + '\'' +
                '}';
    }
}