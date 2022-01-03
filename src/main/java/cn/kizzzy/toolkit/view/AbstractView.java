package cn.kizzzy.toolkit.view;

import cn.kizzzy.event.EventSource;
import cn.kizzzy.helper.LogHelper;
import cn.kizzzy.toolkit.controller.IController;
import cn.kizzzy.toolkit.controller.IControllerHolder;
import javafx.stage.Stage;

public abstract class AbstractView extends EventSource implements IController {
    protected Stage stage;
    protected IControllerHolder holder;
    
    @Override
    public void stop() {
        if (holder != null) {
            holder.remove(this);
        }
        LogHelper.info("Controller[" + getName() + "]已关闭");
    }
    
    @Override
    public void setStage(Stage stage) {
        this.stage = stage;
    }
    
    @Override
    public void setHolder(IControllerHolder holder) {
        this.holder = holder;
    }
    
    @Override
    public void showAndHide() {
        if (stage != null) {
            if (stage.isShowing()) {
                stage.hide();
            } else {
                stage.show();
            }
        }
    }
}
