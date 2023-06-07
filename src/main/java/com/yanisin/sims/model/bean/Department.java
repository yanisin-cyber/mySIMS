package com.yanisin.sims.model.bean;

import javafx.beans.property.SimpleStringProperty;

public class Department {
    private SimpleStringProperty dept_id;
    private SimpleStringProperty dept_name;
    private SimpleStringProperty dept_addr;

    public Department() {
        this("", "", "");
    }

    public Department(String dept_id, String dept_name, String dept_addr) {
        this.dept_id = new SimpleStringProperty(dept_id);
        this.dept_name = new SimpleStringProperty(dept_name);
        this.dept_addr = new SimpleStringProperty(dept_addr);
    }

    public String getDept_id() {
        return dept_id.get();
    }

    public SimpleStringProperty dept_idProperty() {
        return dept_id;
    }

    public void setDept_id(String dept_id) {
        this.dept_id.set(dept_id);
    }

    public String getDept_name() {
        return dept_name.get();
    }

    public SimpleStringProperty dept_nameProperty() {
        return dept_name;
    }

    public void setDept_name(String dept_name) {
        this.dept_name.set(dept_name);
    }

    public String getDept_addr() {
        return dept_addr.get();
    }

    public SimpleStringProperty dept_addrProperty() {
        return dept_addr;
    }

    public void setDept_addr(String dept_addr) {
        this.dept_addr.set(dept_addr);
    }

    @Override
    public String toString() {
        return dept_name.get();
    }
}