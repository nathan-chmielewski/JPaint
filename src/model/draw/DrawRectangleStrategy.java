package model.draw;

import model.interfaces.IDrawShapeStrategy;
import model.interfaces.IShape;
import model.shapes.ShapeColorMap;

import java.awt.*;

// Draw Rectangle strategy methods called by Shape class draw method to render shapes to canvas

public class DrawRectangleStrategy implements IDrawShapeStrategy {

    DrawRectangleStrategy() {
    }

    @Override
    public void drawOutline (Graphics2D graphics2D, IShape rectangle) {
        int width = rectangle.getEndPair().getX() - rectangle.getStartPair().getX();
        int height = rectangle.getEndPair().getY() - rectangle.getStartPair().getY();
        graphics2D.setColor(ShapeColorMap.getMappingForShapeColor(rectangle.getShapeConfiguration().getActivePrimaryColor()));
        graphics2D.setStroke(new BasicStroke(4));
        graphics2D.drawRect(rectangle.getStartPair().getX(), rectangle.getStartPair().getY(), width, height);
    }

    @Override
    public void drawFilledIn (Graphics2D graphics2D, IShape rectangle) {
        int width = rectangle.getEndPair().getX() - rectangle.getStartPair().getX();
        int height = rectangle.getEndPair().getY() - rectangle.getStartPair().getY();
        graphics2D.setColor(ShapeColorMap.getMappingForShapeColor(rectangle.getShapeConfiguration().getActiveSecondaryColor()));
        graphics2D.fillRect(rectangle.getStartPair().getX(), rectangle.getStartPair().getY(), width, height);
    }
}
