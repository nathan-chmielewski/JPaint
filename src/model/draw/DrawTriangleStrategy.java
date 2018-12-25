package model.draw;

import model.clickHandler.Pair;
import model.interfaces.IDrawShapeStrategy;
import model.interfaces.IShape;
import model.shapes.ShapeColorMap;

import java.awt.*;

// Draw Triangle strategy methods called by Shape class draw method to render shapes to canvas
// Two additional methods used to create arrays of X and Y points for Graphics2D drawPolygon method

public class DrawTriangleStrategy implements IDrawShapeStrategy {

    DrawTriangleStrategy() { }

    @Override
    public void drawOutline (Graphics2D graphics2D, IShape triangle) {
        graphics2D.setColor(ShapeColorMap.getMappingForShapeColor(triangle.getShapeConfiguration().getActivePrimaryColor()));
        graphics2D.setStroke(new BasicStroke(4));
        graphics2D.drawPolygon(getXPoints(triangle.getStartPair(),triangle.getEndPair()),
                                    getYPoints(triangle.getStartPair(),triangle.getEndPair()), 3);
    }

    @Override
    public void drawFilledIn (Graphics2D graphics2D, IShape triangle) {
        graphics2D.setColor(ShapeColorMap.getMappingForShapeColor(triangle.getShapeConfiguration().getActiveSecondaryColor()));
        graphics2D.fillPolygon(getXPoints(triangle.getStartPair(),triangle.getEndPair()),
                                    getYPoints(triangle.getStartPair(),triangle.getEndPair()), 3);
    }

    private int[] getXPoints(Pair startPair, Pair endPair) {
        int[] xPoints = new int[3];
        int xPosition1 = startPair.getX();
        int xPosition2 = endPair.getX();
        xPoints[0] = xPosition1;
        xPoints[1] = xPosition1;
        xPoints[2] = xPosition2;
        return xPoints;
    }

    private int[] getYPoints(Pair startPair, Pair endPair) {
        int[] yPoints = new int[3];
        int yPosition1 = startPair.getY();
        int yPosition2 = endPair.getY();
        yPoints[0] = yPosition1;
        yPoints[1] = yPosition2;
        yPoints[2] = yPosition2;
        return yPoints;
    }
}
