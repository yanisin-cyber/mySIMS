package com.yanisin.sims.view;

import com.yanisin.sims.model.bean.Course;
import com.yanisin.sims.model.bean.Department;
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

import java.util.List;

/**
 * @Author: Yanisin
 * @Date: 2023/6/7 23:57
 * @PackageName: com.yanisin.sims.view
 * @ClassName: CourseView
 * @Description: //TODO
 **/
public class CourseView extends BorderPane {
    private ControllerSet controllerSet;
    private TableView tableView;

    public CourseView(List<Course> list) {
        controllerSet = new ControllerSet();
        tableView = new TableView<>();

        tableView.setTableMenuButtonVisible(true);
        TableColumn<CourseView, String> column1 = new TableColumn<>("课程编号");
        TableColumn<CourseView, String> column2 = new TableColumn<>("课程名称");
        TableColumn<CourseView, Number> column3 = new TableColumn<>("学分");
        TableColumn<CourseView, Number> column4 = new TableColumn<>("学时");
        TableColumn<CourseView, Number> column5 = new TableColumn<>("选修学期");

        column1.setCellValueFactory(new PropertyValueFactory<CourseView, String>("cse_id"));
        column2.setCellValueFactory(new PropertyValueFactory<CourseView, String>("cse_name"));
        column3.setCellValueFactory(new PropertyValueFactory<CourseView, Number>("cse_credit"));
        column4.setCellValueFactory(new PropertyValueFactory<CourseView, Number>("cse_period"));
        column5.setCellValueFactory(new PropertyValueFactory<CourseView, Number>("cse_semster"));

        tableView.setEditable(true);
        column1.setEditable(false);

        column2.setCellFactory(TextFieldTableCell.forTableColumn());
        column2.setOnEditCommit(event -> {
            String newValue = event.getNewValue();

            int newIndex = event.getTablePosition().getRow();
            Course course = (Course) tableView.getItems().get(newIndex);

            course.setCse_name(newValue);
            controllerSet.getCourseController().updateCourse(course);
        });

        column3.setCellFactory(TextFieldTableCell.forTableColumn(new StringConverter<Number>() {
            @Override
            public String toString(Number age) {
                return age.toString();
            }

            @Override
            public Integer fromString(String s) {
                return Integer.parseInt(s);
            }
        }));
        column3.setOnEditCommit(event -> {
            Number newValue = event.getNewValue();

            int newIndex = event.getTablePosition().getRow();
            Course course = (Course) tableView.getItems().get(newIndex);

            course.setCse_credit(newValue.intValue());
            controllerSet.getCourseController().updateCourse(course);
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
        column5.setOnEditCommit(event -> {
            Number newValue = event.getNewValue();

            int newIndex = event.getTablePosition().getRow();
            Course course = (Course) tableView.getItems().get(newIndex);

            course.setCse_period(newValue.intValue());
            controllerSet.getCourseController().updateCourse(course);
        });

        column5.setCellFactory(TextFieldTableCell.forTableColumn(new StringConverter<Number>() {
            @Override
            public String toString(Number age) {
                return age.toString();
            }

            @Override
            public Integer fromString(String s) {
                return Integer.parseInt(s);
            }
        }));
        column5.setOnEditCommit(event -> {
            Number newValue = event.getNewValue();

            int newIndex = event.getTablePosition().getRow();
            Course course = (Course) tableView.getItems().get(newIndex);

            course.setCse_semster(newValue.intValue());
            controllerSet.getCourseController().updateCourse(course);
        });

        tableView.getColumns().addAll(column1, column2, column3, column4, column5);

        for(Course course : list)
            tableView.getItems().add(course);

        Label label1 = new Label("课程编号:");
        Label label2 = new Label("课程名称:");
        Label label3 = new Label("学分:");
        Label label4 = new Label("学时:");
        Label label5 = new Label("选修学期:");

        TextField field1 = new TextField();
        TextField field2 = new TextField();
        TextField field3 = new TextField();
        TextField field4 = new TextField();
        TextField field5 = new TextField();

        field3.setPrefWidth(50);
        field4.setPrefWidth(50);
        field5.setPrefWidth(50);

        Button addButton = new Button("添加");
        addButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Course newValue = new Course(
                        field1.getText(),
                        field2.getText(),
                        Integer.parseInt(field3.getText()),
                        Integer.parseInt(field4.getText()),
                        Integer.parseInt(field5.getText())
                );
                controllerSet.getCourseController().insertCourse(newValue);
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
