package com.yanisin.sims.view;

import com.yanisin.sims.model.bean.Department;
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
 * @Date: 2023/6/7 23:48
 * @PackageName: com.yanisin.sims.view
 * @ClassName: DepartmentView
 * @Description: //TODO
 **/
public class DepartmentView extends BorderPane {
    private ControllerSet controllerSet;
    private TableView tableView;

    public DepartmentView(List<Department> list) {
        controllerSet = new ControllerSet();
        tableView = new TableView<>();

        tableView.setTableMenuButtonVisible(true);
        TableColumn<Department, String> column1 = new TableColumn<>("部门编号");
        TableColumn<Department, String> column2 = new TableColumn<>("部门名称");
        TableColumn<Department, String> column3 = new TableColumn<>("部门地址");

        column1.setCellValueFactory(new PropertyValueFactory<Department, String>("dept_id"));
        column2.setCellValueFactory(new PropertyValueFactory<Department, String>("dept_name"));
        column3.setCellValueFactory(new PropertyValueFactory<Department, String>("dept_addr"));

        tableView.setEditable(true);
        column1.setEditable(false);

        column2.setCellFactory(TextFieldTableCell.forTableColumn());
        column2.setOnEditCommit(event -> {
            String newValue = event.getNewValue();

            int newIndex = event.getTablePosition().getRow();
            Department department = (Department) tableView.getItems().get(newIndex);

            department.setDept_name(newValue);
            controllerSet.getDepartmentController().updateDepartment(department);
        });

        column3.setCellFactory(TextFieldTableCell.forTableColumn());
        column3.setOnEditCommit(event -> {
            String newValue = event.getNewValue();

            int newIndex = event.getTablePosition().getRow();
            Department department = (Department) tableView.getItems().get(newIndex);

            department.setDept_addr(newValue);
            controllerSet.getDepartmentController().updateDepartment(department);
        });

        tableView.getColumns().addAll(column1, column2, column3);

        for(Department department : list)
            tableView.getItems().add(department);

        Label label1 = new Label("部门编号:");
        Label label2 = new Label("部门名称:");
        Label label3 = new Label("部门地址:");

        TextField field1 = new TextField();
        TextField field2 = new TextField();
        TextField field3 = new TextField();


        Button addButton = new Button("添加");
        addButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Department newValue = new Department(
                        field1.getText(),
                        field2.getText(),
                        field3.getText()
                );
                controllerSet.getDepartmentController().insertDepartment(newValue);
                tableView.getItems().add(newValue);
            }
        });

        HBox addBar = new HBox();
        addBar.getChildren().addAll(label1, field1);
        addBar.getChildren().addAll(label2, field2);
        addBar.getChildren().addAll(label3, field3);
        addBar.getChildren().add(addButton);

        this.setTop(addBar);
        this.setCenter(tableView);
    }
}
