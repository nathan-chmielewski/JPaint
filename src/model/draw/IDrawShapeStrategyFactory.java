package model.draw;

import model.interfaces.IDrawShapeStrategy;

public class IDrawShapeStrategyFactory {

    public static IDrawShapeStrategy createDrawEllipseStrategy() {
        return new DrawEllipseStrategy();
    }

    public static IDrawShapeStrategy createDrawRectangleStrategy() {
        return new DrawRectangleStrategy();
    }

    public static IDrawShapeStrategy createDrawTriangleStrategy() {
        return new DrawTriangleStrategy();
    }
}
