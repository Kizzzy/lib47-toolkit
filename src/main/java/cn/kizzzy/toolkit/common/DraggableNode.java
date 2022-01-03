package cn.kizzzy.toolkit.common;

import javafx.scene.Node;
import javafx.scene.input.MouseButton;

public class DraggableNode {
    private final Node node;
    
    private boolean valid = true;
    private double initialY;
    private double initialX;
    
    public DraggableNode(final Node node) {
        this.node = node;
        
        node.setOnMousePressed(event -> {
            if (valid && event.getButton() == MouseButton.PRIMARY) {
                initialX = event.getSceneX();
                initialY = event.getSceneY();
            }
        });
        
        node.setOnMouseDragged(event -> {
            if (valid && event.getButton() == MouseButton.PRIMARY) {
                node.getScene().getWindow().setX(event.getScreenX() - initialX);
                node.getScene().getWindow().setY(event.getScreenY() - initialY);
            }
        });
    }
    
    public boolean isValid() {
        return valid;
    }
    
    public void setValid(boolean valid) {
        this.valid = valid;
    }
}
