package com.yanisin.sims.view;

import com.yanisin.sims.model.bean.Lesson;
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
 * @Date: 2023/6/7 22:18
 * @PackageName: com.yanisin.sims.view
 * @ClassName: LessonView
 * @Description: //TODO
 **/
public class LessonView extends BorderPane {
    private ControllerSet controllerSet;
    private TableView tableView;

    public LessonView(List<Lesson> list) {
        controllerSet = new ControllerSet();
        tableView = new TableView<>();

        tableView.setTableMenuButtonVisible(true);
        TableColumn<Lesson, String> column1 = new TableColumn<>("学生编号");
        TableColumn<Lesson, String> column2 = new TableColumn<>("课程编号");
        TableColumn<Lesson, String> column3 = new TableColumn<>("教师编号");
        TableColumn<Lesson, Number> column4 = new TableColumn<>("课程成绩");

        column1.setCellValueFactory(new PropertyValueFactory<Lesson, String>("les_stu_id"));
        column2.setCellValueFactory(new PropertyValueFactory<Lesson, String>("les_cse_id"));
        column3.setCellValueFactory(new PropertyValueFactory<Lesson, String>("les_tch_id"));
        column4.setCellValueFactory(new PropertyValueFactory<Lesson, Number>("les_grade"));

        tableView.setEditable(true);
        column1.setEditable(false);
        column2.setEditable(false);
        column3.setEditable(false);

        column4.setCellFactory(TextFieldTableCell.forTableColumn(new StringConverter<Number>() {
            @Override
            public String toString(Number grade) {
                return grade.toString();
            }
            @Override
            public Integer fromString(String s) {
                return Integer.parseInt(s);
            }
        }));
        column4.setOnEditCommit(event -> {
            Number newValue = event.getNewValue();
            int newIndex = event.getTablePosition().getRow();
            Lesson lesson = (Lesson) tableView.getItems().get(newIndex);
            lesson.setLes_grade(newValue.intValue());
            controllerSet.getLessonController().updateLesson(lesson);
        });

        tableView.getColumns().addAll(column1, column2, column3, column4);

        for(Lesson lesson : list)
            tableView.getItems().add(lesson);

        Label label1 = new Label("学生编号:");
        Label label2 = new Label("课程编号:");
        Label label3 = new Label("教师编号:");
        Label label4 = new Label("课程成绩:");

        TextField field1 = new TextField();
        TextField field2 = new TextField();
        TextField field3 = new TextField();
        TextField field4 = new TextField();

        field4.setPrefWidth(50);

        Button addButton = new Button("添加");
        addButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Lesson newValue = new Lesson(
                        field1.getText(),
                        field2.getText(),
                        field3.getText(),
                        Integer.parseInt(field4.getText())
                );
                controllerSet.getLessonController().insertLesson(newValue);
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
