package cn.kizzzy.toolkit.view;

import cn.kizzzy.event.EventSource;
import cn.kizzzy.toolkit.controller.IController;
import cn.kizzzy.toolkit.controller.IControllerHolder;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractView extends EventSource implements IController {
    
    protected static final Logger logger = LoggerFactory.getLogger(AbstractView.class);
    
    protected Stage stage;
    protected IControllerHolder holder;
    
    @Override
    public void stop() {
        if (holder != null) {
            holder.remove(this);
        }
        logger.info("Controller[" + getName() + "]已关闭");
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
