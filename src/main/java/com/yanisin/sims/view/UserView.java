package com.yanisin.sims.view;

import com.yanisin.sims.model.bean.User;
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
 * @Date: 2023/6/8 0:21
 * @PackageName: com.yanisin.sims.view
 * @ClassName: UserView
 * @Description: //TODO
 **/
public class UserView extends BorderPane {
    private ControllerSet controllerSet;
    private TableView tableView;

    public UserView(List<User> list) {
        controllerSet = new ControllerSet();
        tableView = new TableView<>();

        tableView.setTableMenuButtonVisible(true);
        TableColumn<User, String> column1 = new TableColumn<>("用户账号");
        TableColumn<User, String> column2 = new TableColumn<>("用户密码");
        TableColumn<User, Number> column3 = new TableColumn<>("用户类别");

        column1.setCellValueFactory(new PropertyValueFactory<User, String>("user_id"));
        column2.setCellValueFactory(new PropertyValueFactory<User, String>("user_password"));
        column3.setCellValueFactory(new PropertyValueFactory<User, Number>("superManager"));

        tableView.setEditable(true);

        column1.setCellFactory(TextFieldTableCell.forTableColumn());
        column1.setOnEditCommit(event -> {
            String newValue = event.getNewValue();
            int newIndex = event.getTablePosition().getRow();
            User user = (User) tableView.getItems().get(newIndex);
            user.setUser_id(newValue);
            controllerSet.getUserController().updateUser(user);
        });

        column2.setCellFactory(TextFieldTableCell.forTableColumn());
        column2.setOnEditCommit(event -> {
            String newValue = event.getNewValue();
            int newIndex = event.getTablePosition().getRow();
            User user = (User) tableView.getItems().get(newIndex);
            user.setUser_password(newValue);
            controllerSet.getUserController().updateUser(user);
        });

        column3.setCellFactory(TextFieldTableCell.forTableColumn(new StringConverter<Number>() {
            @Override
            public String toString(Number grade) {
                return grade.toString();
            }
            @Override
            public Integer fromString(String s) {
                return Integer.parseInt(s);
            }
        }));
        column3.setOnEditCommit(event -> {
            Number newValue = event.getNewValue();
            int newIndex = event.getTablePosition().getRow();
            User user = (User) tableView.getItems().get(newIndex);
            user.setSuperManager((newValue.intValue() == 0 ? 1 : 0));
            controllerSet.getUserController().updateUser(user);
        });

        tableView.getColumns().addAll(column1, column2, column3);

        for(User user : list)
            tableView.getItems().add(user);

        Label label1 = new Label("用户账号:");
        Label label2 = new Label("用户密码:");
        Label label3 = new Label("用户类别:");

        TextField field1 = new TextField();
        TextField field2 = new TextField();
        TextField field3 = new TextField();

        Button addButton = new Button("添加");
        addButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                User newValue = new User(
                        field1.getText(),
                        field2.getText(),
                        Integer.parseInt(field3.getText())
                );
                controllerSet.getUserController().insertUser(newValue);
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
