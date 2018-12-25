package model.draw;

import model.interfaces.IDrawShapeStrategy;
import model.interfaces.IShape;
import model.shapes.ShapeColorMap;

import java.awt.*;

// Draw Ellipse strategy methods called by Shape class draw method to render shapes to canvas

public class DrawEllipseStrategy implements IDrawShapeStrategy {

    DrawEllipseStrategy() {
    }

    @Override
    public void drawOutline (Graphics2D graphics2D, IShape ellipse) {
        int width = ellipse.getEndPair().getX() - ellipse.getStartPair().getX();
        int height = ellipse.getEndPair().getY() - ellipse.getStartPair().getY();
        graphics2D.setColor(ShapeColorMap.getMappingForShapeColor(ellipse.getShapeConfiguration().getActivePrimaryColor()));
        graphics2D.setStroke(new BasicStroke(4));
        graphics2D.drawOval(ellipse.getStartPair().getX(), ellipse.getStartPair().getY(), width, height);
    }

    @Override
    public void drawFilledIn (Graphics2D graphics2D, IShape ellipse) {
        int width = ellipse.getEndPair().getX() - ellipse.getStartPair().getX();
        int height = ellipse.getEndPair().getY() - ellipse.getStartPair().getY();
        graphics2D.setColor(ShapeColorMap.getMappingForShapeColor(ellipse.getShapeConfiguration().getActiveSecondaryColor()));
        graphics2D.fillOval(ellipse.getStartPair().getX(), ellipse.getStartPair().getY(), width, height);
    }
}
