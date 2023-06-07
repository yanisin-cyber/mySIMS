package com.yanisin.sims.model.bean;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class User {
    private SimpleStringProperty user_id;
    private SimpleStringProperty user_password;
    private SimpleIntegerProperty superManager;

    public User() {
        this("", "", 0);
    }

    public User(String user_id, String user_password, int superManager) {
        this.user_id = new SimpleStringProperty(user_id);
        this.user_password = new SimpleStringProperty(user_password);
        this.superManager = new SimpleIntegerProperty(superManager);
    }

    public String getUser_id() {
        return user_id.get();
    }

    public SimpleStringProperty user_idProperty() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id.set(user_id);
    }

    public String getUser_password() {
        return user_password.get();
    }

    public SimpleStringProperty user_passwordProperty() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password.set(user_password);
    }

    public int getSuperManager() {
        return superManager.get();
    }

    public SimpleIntegerProperty superManagerProperty() {
        return superManager;
    }

    public void setSuperManager(int superManager) {
        this.superManager.set(superManager);
    }

    @Override
    public String toString() {
        return "User{" +
                "user_id='" + user_id.get() + '\'' +
                ", user_password='" + user_password.get() + '\'' +
                ", superManager=" + superManager.get() +
                '}';
    }
}