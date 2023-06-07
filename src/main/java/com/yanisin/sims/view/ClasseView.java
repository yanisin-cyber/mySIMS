package com.yanisin.sims.view;

import com.yanisin.sims.model.bean.Classe;
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
 * @Date: 2023/6/7 22:49
 * @PackageName: com.yanisin.sims.view
 * @ClassName: ClasseView
 * @Description: //TODO
 **/
public class ClasseView extends BorderPane {
    private ControllerSet controllerSet;
    private TableView tableView;

    public ClasseView(List<Classe> list) {
        controllerSet = new ControllerSet();
        tableView = new TableView<>();

        tableView.setTableMenuButtonVisible(true);
        TableColumn<Classe, String> column1 = new TableColumn<>("班级编号");
        TableColumn<Classe, String> column2 = new TableColumn<>("专业名称");
        TableColumn<Classe, String> column3 = new TableColumn<>("院系编号");
        TableColumn<Classe, String> column4 = new TableColumn<>("班主任"  );

        column1.setCellValueFactory(new PropertyValueFactory<Classe, String>("class_id"));
        column2.setCellValueFactory(new PropertyValueFactory<Classe, String>("class_subject"));
        column3.setCellValueFactory(new PropertyValueFactory<Classe, String>("class_dept_id"));
        column4.setCellValueFactory(new PropertyValueFactory<Classe, String>("class_manager_tch_id"));

        tableView.setEditable(true);
        column1.setEditable(false);

        column2.setCellFactory(TextFieldTableCell.forTableColumn());
        column2.setOnEditCommit(event -> {
            String newValue = event.getNewValue();

            int newIndex = event.getTablePosition().getRow();
            Classe classe = (Classe) tableView.getItems().get(newIndex);

            classe.setClass_subject(newValue);
            controllerSet.getClasseController().updateClasse(classe);
        });

        column3.setCellFactory(TextFieldTableCell.forTableColumn());
        column3.setOnEditCommit(event -> {
            String newValue = event.getNewValue();

            int newIndex = event.getTablePosition().getRow();
            Classe classe = (Classe) tableView.getItems().get(newIndex);

            classe.setClass_dept_id(newValue);
            controllerSet.getClasseController().updateClasse(classe);
        });

        column4.setCellFactory(TextFieldTableCell.forTableColumn());
        column4.setOnEditCommit(event -> {
            String newValue = event.getNewValue();

            int newIndex = event.getTablePosition().getRow();
            Classe classe = (Classe) tableView.getItems().get(newIndex);

            classe.setClass_manager_tch_id(newValue);
            controllerSet.getClasseController().updateClasse(classe);
        });

        tableView.getColumns().addAll(column1, column2, column3, column4);

        for(Classe classe : list)
            tableView.getItems().add(classe);

        Label label1 = new Label("班级编号:");
        Label label2 = new Label("专业名称:");
        Label label3 = new Label("院系编号:");
        Label label4 = new Label("班主任:");


        TextField field1 = new TextField();
        TextField field2 = new TextField();
        TextField field3 = new TextField();
        TextField field4 = new TextField();

        Button addButton = new Button("添加");
        addButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Classe newValue = new Classe(
                        field1.getText(),
                        field2.getText(),
                        field3.getText(),
                        field4.getText()
                    );
                controllerSet.getClasseController().insertClasse(newValue);
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
