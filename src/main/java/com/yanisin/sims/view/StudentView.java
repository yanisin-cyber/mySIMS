package com.yanisin.sims.view;

import com.yanisin.sims.model.bean.Student;
import com.yanisin.sims.model.util.ControllerSet;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.util.StringConverter;

import javax.swing.text.TabableView;
import java.util.List;

/**
 * @Author: Yanisin
 * @Date: 2023/6/5 20:01
 * @PackageName: com.yanisin.sims.view
 * @ClassName: StudentView
 * @Description: //TODO
 **/
public class StudentView extends BorderPane {
    private ControllerSet controllerSet;
    private TabableView tabableView;
    public StudentView(List<Student> list) {
        controllerSet = new ControllerSet();

        TableView tableView = new TableView<>();
        tableView.setTableMenuButtonVisible(true);

        TableColumn<Student, String> column1 = new TableColumn<>("学号");
        TableColumn<Student, String> column2 = new TableColumn<>("姓名");
        TableColumn<Student, String> column3 = new TableColumn<>("性别");
        TableColumn<Student, Number> column4 = new TableColumn<>("年纪");
        TableColumn<Student, String> column5 = new TableColumn<>("班级");

        column1.setCellValueFactory(new PropertyValueFactory<Student, String>("stu_id"));
        column2.setCellValueFactory(new PropertyValueFactory<Student, String>("stu_name"));
        column3.setCellValueFactory(new PropertyValueFactory<Student, String>("stu_sex"));
        column4.setCellValueFactory(new PropertyValueFactory<Student, Number>("stu_age"));
        column5.setCellValueFactory(new PropertyValueFactory<Student, String>("stu_class_id"));

        tableView.setEditable(true);
        column1.setEditable(false);

        column2.setCellFactory(TextFieldTableCell.forTableColumn());
        column2.setOnEditCommit(event -> {
            String newValue = event.getNewValue();

            int newIndex = event.getTablePosition().getRow();
            Student student = (Student) tableView.getItems().get(newIndex);

            student.setStu_name(newValue);
            controllerSet.getStudentController().updateStudent(student);
        });

        column3.setCellFactory(TextFieldTableCell.forTableColumn());
        column3.setOnEditCommit(event -> {
            String newValue = event.getNewValue();

            int newIndex = event.getTablePosition().getRow();
            Student student = (Student) tableView.getItems().get(newIndex);

            student.setStu_sex(newValue);
            controllerSet.getStudentController().updateStudent(student);
        });

        column4.setCellFactory(TextFieldTableCell.forTableColumn(new StringConverter<Number>() {
            @Override
            public String toString(Number age) {
                return age.toString();
            }

            @Override
            public Integer fromString(String s) {
                return Integer.parseInt(s);
            }
        }));
        column4.setOnEditCommit(event -> {
            Number newValue = event.getNewValue();

            int newIndex = event.getTablePosition().getRow();
            Student student = (Student) tableView.getItems().get(newIndex);

            student.setStu_age(newValue.intValue());
            controllerSet.getStudentController().updateStudent(student);
        });

        column5.setCellFactory(TextFieldTableCell.forTableColumn());
        column5.setOnEditCommit(event -> {
            String newValue = event.getNewValue();

            int newIndex = event.getTablePosition().getRow();
            Student student = (Student) tableView.getItems().get(newIndex);

            student.setStu_sex(newValue);
            controllerSet.getStudentController().updateStudent(student);
        });

        tableView.getColumns().addAll(column1, column2, column3, column4, column5);

        for(Student student : list)
            tableView.getItems().add(student);

        Label label1 = new Label("学号:");
        Label label2 = new Label("姓名:");
        Label label3 = new Label("性别:");
        Label label4 = new Label("年龄:");
        Label label5 = new Label("班级:");

        TextField field1 = new TextField();
        TextField field2 = new TextField();
        TextField field3 = new TextField();
        TextField field4 = new TextField();
        TextField field5 = new TextField();

        field2.setPrefWidth(50);
        field3.setPrefWidth(50);
        field4.setPrefWidth(50);

        Button addButton = new Button("添加");
        addButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Student newValue = new Student(
                        field1.getText(),
                        field2.getText(),
                        field3.getText(),
                        Integer.parseInt(field4.getText()),
                        field5.getText()
                );
                controllerSet.getStudentController().insertStudent(newValue);
                tableView.getItems().add(newValue);
            }
        });

        HBox addBar = new HBox();
        addBar.getChildren().addAll(label1, field1);
        addBar.getChildren().addAll(label2, field2);
        addBar.getChildren().addAll(label3, field3);
        addBar.getChildren().addAll(label4, field4);
        addBar.getChildren().addAll(label5, field5);
        addBar.getChildren().add(addButton);

        this.setTop(addBar);
        this.setCenter(tableView);
    }
}
