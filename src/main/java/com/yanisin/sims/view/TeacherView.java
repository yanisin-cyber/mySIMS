package com.yanisin.sims.view;

import com.yanisin.sims.model.bean.Teacher;
import com.yanisin.sims.model.util.ControllerSet;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

import java.util.List;

/**
 * @Author: Yanisin
 * @Date: 2023/6/7 23:38
 * @PackageName: com.yanisin.sims.view
 * @ClassName: TeacherView
 * @Description: //TODO
 **/
public class TeacherView extends BorderPane {
    private ControllerSet controllerSet;
    private TableView tableView;

    public TeacherView(List<Teacher> list) {
        controllerSet = new ControllerSet();
        tableView = new TableView<>();

        tableView.setTableMenuButtonVisible(true);
        TableColumn<Teacher, String> column1 = new TableColumn<>("教师编号");
        TableColumn<Teacher, String> column2 = new TableColumn<>("教师姓名");
        TableColumn<Teacher, String> column3 = new TableColumn<>("教师职称");
        TableColumn<Teacher, String> column4 = new TableColumn<>("所属院系");

        column1.setCellValueFactory(new PropertyValueFactory<Teacher, String>("tch_id"));
        column2.setCellValueFactory(new PropertyValueFactory<Teacher, String>("tch_name"));
        column3.setCellValueFactory(new PropertyValueFactory<Teacher, String>("tch_tittle"));
        column4.setCellValueFactory(new PropertyValueFactory<Teacher, String>("tch_dept_id"));

        tableView.setEditable(true);
        column1.setEditable(false);

        column2.setCellFactory(TextFieldTableCell.forTableColumn());
        column2.setOnEditCommit(event -> {
            String newValue = event.getNewValue();

            int newIndex = event.getTablePosition().getRow();
            Teacher teacher = (Teacher) tableView.getItems().get(newIndex);

            teacher.setTch_name(newValue);
            controllerSet.getTeacherController().updateTeacher(teacher);
        });

        column3.setCellFactory(TextFieldTableCell.forTableColumn());
        column3.setOnEditCommit(event -> {
            String newValue = event.getNewValue();

            int newIndex = event.getTablePosition().getRow();
            Teacher teacher = (Teacher) tableView.getItems().get(newIndex);

            teacher.setTch_tittle(newValue);
            controllerSet.getTeacherController().updateTeacher(teacher);
        });

        column4.setCellFactory(TextFieldTableCell.forTableColumn());
        column4.setOnEditCommit(event -> {
            String newValue = event.getNewValue();

            int newIndex = event.getTablePosition().getRow();
            Teacher teacher = (Teacher) tableView.getItems().get(newIndex);

            teacher.setTch_dept_id(newValue);
            controllerSet.getTeacherController().updateTeacher(teacher);
        });

        tableView.getColumns().addAll(column1, column2, column3, column4);

        for(Teacher teacher : list)
            tableView.getItems().add(teacher);

        Label label1 = new Label("教师编号:");
        Label label2 = new Label("教师姓名:");
        Label label3 = new Label("教师职称:");
        Label label4 = new Label("所属院系:");


        TextField field1 = new TextField();
        TextField field2 = new TextField();
        TextField field3 = new TextField();
        TextField field4 = new TextField();

        Button addButton = new Button("添加");
        addButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Teacher newValue = new Teacher(
                        field1.getText(),
                        field2.getText(),
                        field3.getText(),
                        field4.getText()
                );
                controllerSet.getTeacherController().insertTeacher(newValue);
                tableView.getItems().add(newValue);
            }
        });

        HBox addBar = new HBox();
        addBar.getChildren().addAll(label1, field1);
        addBar.getChildren().addAll(label2, field2);
        addBar.getChildren().addAll(label3, field3);
        addBar.getChildren().addAll(label4, field4);
        addBar.getChildren().add(addButton);

        this.setTop(addBar);
        this.setCenter(tableView);
    }
}
