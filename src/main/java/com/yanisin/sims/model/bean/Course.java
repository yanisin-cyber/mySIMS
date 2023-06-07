package com.yanisin.sims.model.bean;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Course {
    private SimpleStringProperty cse_id;
    private SimpleStringProperty cse_name;
    private SimpleIntegerProperty cse_credit;
    private SimpleIntegerProperty cse_period;
    private SimpleIntegerProperty cse_semster;

    public Course() {
        this("", "", 0, 0, 0);
    }

    public Course(String cse_id, String cse_name, int cse_credit, int cse_period, int cse_semster) {
        this.cse_id = new SimpleStringProperty(cse_id);
        this.cse_name = new SimpleStringProperty(cse_name);
        this.cse_credit = new SimpleIntegerProperty(cse_credit);
        this.cse_period = new SimpleIntegerProperty(cse_period);
        this.cse_semster = new SimpleIntegerProperty(cse_semster);
    }

    public String getCse_id() {
        return cse_id.get();
    }

    public SimpleStringProperty cse_idProperty() {
        return cse_id;
    }

    public void setCse_id(String cse_id) {
        this.cse_id.set(cse_id);
    }

    public String getCse_name() {
        return cse_name.get();
    }

    public SimpleStringProperty cse_nameProperty() {
        return cse_name;
    }

    public void setCse_name(String cse_name) {
        this.cse_name.set(cse_name);
    }

    public int getCse_credit() {
        return cse_credit.get();
    }

    public SimpleIntegerProperty cse_creditProperty() {
        return cse_credit;
    }

    public void setCse_credit(int cse_credit) {
        this.cse_credit.set(cse_credit);
    }

    public int getCse_period() {
        return cse_period.get();
    }

    public SimpleIntegerProperty cse_periodProperty() {
        return cse_period;
    }

    public void setCse_period(int cse_period) {
        this.cse_period.set(cse_period);
    }

    public int getCse_semster() {
        return cse_semster.get();
    }

    public SimpleIntegerProperty cse_semsterProperty() {
        return cse_semster;
    }

    public void setCse_semster(int cse_semster) {
        this.cse_semster.set(cse_semster);
    }

    @Override
    public String toString() {
        return "Course{" +
                "cse_id='" + cse_id.get() + '\'' +
                ", cse_name='" + cse_name.get() + '\'' +
                ", cse_credit=" + cse_credit.get() +
                ", cse_period=" + cse_period.get() +
                ", cse_semster=" + cse_semster.get() +
                '}';
    }
}