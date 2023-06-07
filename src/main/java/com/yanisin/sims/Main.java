package com.yanisin.sims;


import com.yanisin.sims.view.LoginPane;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        initStage(stage);
        Scene rootScene = new Scene(new Pane());
        rootScene.setRoot(new LoginPane(rootScene));
        stage.setScene(rootScene);
        stage.show();
    }

    private void initStage(Stage stage) {
        stage.setTitle("SIMS");
        stage.getIcons().add(new Image("images/icon.png"));
        stage.setWidth(1000*1.15);
        stage.setHeight(618*1.15);
    }
}















/*
SIMS/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── com.yanisin.sims/
│   │   │   │   ├── config
│   │   │   │   │   ├── SpringConfig.java
│   │   │   │   ├── controller
│   │   │   │   ├── model
│   │   │   │   │   ├── bean/
│   │   │   │   │   ├── mapper/
│   │   │   │   │   ├── util/
│   │   │   │   │   ├── service/
│   │   │   │   ├── view
│   │   │   │   ├── Main.java
│   │   ├── resources/
│   │   │   ├── Mappers/
│   │   │   ├── dbconfig.properties
│   │   │   ├── mybatis-config.xml
* */