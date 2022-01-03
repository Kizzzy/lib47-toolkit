package cn.kizzzy.toolkit.controller;

import javafx.stage.Stage;

public interface IController {

    String getName();

    void stop();

    void showAndHide();

    void setStage(Stage stage);

    void setHolder(IControllerHolder holder);
}
