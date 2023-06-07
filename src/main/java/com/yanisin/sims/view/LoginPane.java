package com.yanisin.sims.view;

import com.yanisin.sims.controller.impl.LoginControllerImpl;
import com.yanisin.sims.controller.intfa.LoginController;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


/**
 * @Author: Yanisin
 * @Date: 2023/5/31 16:19
 * @PackageName: com.yanisin.sims.view
 * @ClassName: LoginView
 * @Description: //TODO
 **/
public class LoginPane extends BorderPane {
    private LoginController  loginController;
    private Label tittle;
    private Label usernameLable;
    private Label passwordLable;
    private TextField usernameField;
    private PasswordField passwordField;
    private Button loginButton;


    public LoginPane(Scene rootScene) {
        loginController = new LoginControllerImpl();

        tittle = new Label("用户登录");
        usernameLable = new Label("账户: ");
        usernameField = new TextField();
        passwordLable = new Label("密码: ");
        passwordField = new PasswordField();
        loginButton = new Button("Login");
        loginButton.setOnAction(event -> {
            String username = usernameField.getText();
            String password = passwordField.getText();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("登录提示");
            if (isValidLogin(username, password)) {
                rootScene.setRoot(new MainPane(rootScene));
            }
            else {
                alert.setTitle("Login Failed");
                alert.setContentText("账户名或密码错误，请验证重试或联系管理员");
                alert.show();
            }
        });

        VBox loginVBox = new VBox(10);
        HBox usernameHBox = new HBox(usernameLable, usernameField);
        HBox passwordHBox = new HBox(passwordLable, passwordField);
        loginVBox.getChildren().addAll(tittle, usernameHBox, passwordHBox, loginButton);
        loginVBox.setAlignment(Pos.CENTER);
        loginVBox.setMaxSize(200, 124);
        this.setCenter(loginVBox);
    }

    private boolean isValidLogin(String username, String password) {
        return loginController.isValidLogin(username, password);
    }
}
