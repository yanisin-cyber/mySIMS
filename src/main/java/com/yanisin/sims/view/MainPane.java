package com.yanisin.sims.view;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

/**
 * @Author: Yanisin
 * @Date: 2023/6/3 17:35
 * @PackageName: com.yanisin.sims.view
 * @ClassName: MainView
 * @Description: //TODO
 **/
public class MainPane extends BorderPane {
    private BorderPane sideBar = new BorderPane();
    private BorderPane content = new BorderPane();

    public MainPane(Scene rootScene) {
        this.content.setCenter(new Label("hello, world"));
        this.setLeft(new SidebarPane(content));
        this.setCenter(content);
    }
}
