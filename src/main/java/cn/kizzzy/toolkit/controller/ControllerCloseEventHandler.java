package cn.kizzzy.toolkit.controller;

import javafx.event.EventHandler;
import javafx.stage.WindowEvent;

public class ControllerCloseEventHandler implements EventHandler<WindowEvent> {
    private IController controller;

    public ControllerCloseEventHandler(IController controller) {
        this.controller = controller;
    }

    @Override
    public void handle(WindowEvent event) {
        if (event.getEventType() == WindowEvent.WINDOW_CLOSE_REQUEST) {
            controller.stop();
        }
    }
}
