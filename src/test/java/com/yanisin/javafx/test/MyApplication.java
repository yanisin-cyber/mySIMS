package com.yanisin.javafx.test;

import com.yanisin.sims.controller.impl.StudentControllerImpl;
import com.yanisin.sims.controller.intfa.StudentController;
import com.yanisin.sims.model.bean.Student;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.StringConverter;


import java.util.List;


/**
 * @Author: Yanisin
 * @Date: 2023/5/31 11:27
 * @PackageName: com.yanisin.javafx.test
 * @ClassName: Main
 * @Description: //TODO
 **/
public class MyApplication extends Application {
    private StudentController studentController = new StudentControllerImpl();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Scene root = new Scene(studentView());
        stage.setScene(root);
        stage.show();
    }

    public Pane studentView() {

        ObservableList<Student> studentList = FXCollections.observableArrayList();
        TableView tableView = new TableView<>(studentList);
        tableView.setPrefSize(500, 300);
        tableView.setTableMenuButtonVisible(true);



        TableColumn<Student, String> stuID   = new TableColumn<>("学号");
        TableColumn<Student, String> stuName = new TableColumn<>("姓名");
        TableColumn<Student, String> stuSex  = new TableColumn<>("性别");
        TableColumn<Student, Number> stuAge  = new TableColumn<>("年纪");
        TableColumn<Student, String> stuClassID = new TableColumn<>("班级");

        stuID.setCellValueFactory(new PropertyValueFactory<Student, String>("stu_id"));
        stuName.setCellValueFactory(new PropertyValueFactory<Student, String>("stu_name"));
        stuSex.setCellValueFactory(new PropertyValueFactory<Student, String>("stu_sex"));
        stuAge.setCellValueFactory(new PropertyValueFactory<Student, Number>("stu_age"));
        stuClassID.setCellValueFactory(new PropertyValueFactory<Student, String>("stu_class_id"));

        tableView.setEditable(true);
        stuID.setEditable(false);
        stuName.setEditable(true);
        stuSex.setEditable(true);
        stuAge.setEditable(true);
        stuClassID.setEditable(true);

        stuID.setCellFactory(TextFieldTableCell.forTableColumn());
        stuID.setOnEditCommit(event -> {
            String newValue = event.getNewValue();

            int newIndex = event.getTablePosition().getRow();
            Student student = (Student) tableView.getItems().get(newIndex);

            student.setStu_id(newValue);
            studentController.updateStudent(student);
        });
        stuName.setCellFactory(TextFieldTableCell.forTableColumn());
        stuName.setOnEditCommit(event -> {
            String newValue = event.getNewValue();

            int newIndex = event.getTablePosition().getRow();
            Student student = (Student) tableView.getItems().get(newIndex);

            student.setStu_name(newValue);
            studentController.updateStudent(student);
        });
        stuSex.setCellFactory(TextFieldTableCell.forTableColumn());
        stuSex.setOnEditCommit(event -> {
            String newValue = event.getNewValue();

            int newIndex = event.getTablePosition().getRow();
            Student student = (Student) tableView.getItems().get(newIndex);

            student.setStu_sex(newValue);
            studentController.updateStudent(student);
        });

        stuAge.setCellFactory(TextFieldTableCell.forTableColumn(new StringConverter<Number>() {
            @Override
            public String toString(Number age) {
                return age.toString();
            }

            @Override
            public Integer fromString(String s) {
                return Integer.parseInt(s);
            }
        }));
        stuAge.setOnEditCommit(event -> {
            Number newValue = event.getNewValue();

            int newIndex = event.getTablePosition().getRow();
            Student student = (Student) tableView.getItems().get(newIndex);

            student.setStu_age(newValue.intValue());
            studentController.updateStudent(student);
        });

        stuClassID.setCellFactory(TextFieldTableCell.forTableColumn());
        stuClassID.setOnEditCommit(event -> {
            String newValue = event.getNewValue();

            int newIndex = event.getTablePosition().getRow();
            Student student = (Student) tableView.getItems().get(newIndex);

            student.setStu_sex(newValue);
            studentController.updateStudent(student);
        });

        tableView.getColumns().addAll(stuID, stuName, stuSex, stuAge, stuClassID);

        List<Student> students = studentController.getAllStudents();
        for(Student student : students)
            tableView.getItems().add(student);




//        Label info = new Label("添加学生");
        Label sno = new Label("学号:");
        Label sname = new Label("姓名:");
        Label ssex = new Label("性别:");
        Label sage = new Label("年龄:");
        Label scls = new Label("班级:");

        TextField snof = new TextField();
        TextField snamef = new TextField();
        TextField ssexf = new TextField();
        TextField sagef = new TextField();
        TextField sclsf = new TextField();

        Button addB = new Button("添加");

        HBox addBar = new HBox();
        addBar.getChildren().addAll(sno, snof);
        addBar.getChildren().addAll(sname, snamef);
        addBar.getChildren().addAll(ssex, ssexf);
        addBar.getChildren().addAll(sage, sagef);
        addBar.getChildren().addAll(scls, sclsf);
        addBar.getChildren().add(addB);

        addB.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Student newValue = new Student(
                        snof.getText(),
                        snamef.getText(),
                        ssexf.getText(),
                        Integer.parseInt(sagef.getText()),
                        sclsf.getText()
                );
                studentController.insertStudent(newValue);
                tableView.getItems().add(newValue);
            }
        });
        BorderPane bp = new BorderPane();
        bp.setCenter(tableView);
        bp.setTop(addBar);

        return bp;
    }

}



