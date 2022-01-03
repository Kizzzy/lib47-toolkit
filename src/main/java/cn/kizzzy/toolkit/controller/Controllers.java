package cn.kizzzy.toolkit.controller;

import cn.kizzzy.helper.LogHelper;
import cn.kizzzy.helper.StringHelper;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.InputStream;

public class Controllers {
    
    public static <T extends IController> T start(IControllerHolder holder, Stage stage, Class<T> clazz) {
        try {
            PluginParameter parameter = clazz.getAnnotation(PluginParameter.class);
            if (parameter == null) {
                throw new IllegalArgumentException("");
            }
            
            T controller = clazz.newInstance();
            controller.setStage(stage);
            controller.setHolder(holder);
    
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Controllers.class.getResource(parameter.url()));
            loader.setControllerFactory(c -> controller);
    
            Parent root = loader.load();
            
            Scene scene = new Scene(root);
            if (parameter.transparent()) {
                scene.setFill(Color.TRANSPARENT);
                scene.getRoot().setStyle("-fx-background-color: transparent;");
            }
            
            stage = stage != null ? stage : new Stage();
            
            stage.setTitle(parameter.title());
            stage.setResizable(parameter.resize());
            stage.sizeToScene();
            stage.setAlwaysOnTop(parameter.top());
            stage.setScene(scene);
            stage.setOnCloseRequest(new ControllerCloseEventHandler(controller));
            if (parameter.transparent()) {
                stage.initStyle(StageStyle.TRANSPARENT);
            }
            
            if (StringHelper.isNotNullAndEmpty(parameter.icon())) {
                try (InputStream is = Controllers.class.getResourceAsStream(parameter.icon())) {
                    stage.getIcons().add(new Image(is));
                }
            }
            
            if (parameter.show()) {
                stage.show();
            }
            
            return controller;
        } catch (Exception e) {
            LogHelper.error("load controller failed!!!", e);
            return null;
        }
    }
}
