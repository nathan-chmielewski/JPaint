package model.shapes;

import model.clickHandler.Pair;
import model.interfaces.IShape;

public class IShapeFactory {
    private IShapeFactory() {}

    public static IShape createShape(Pair startPair, Pair endPair, ShapeConfiguration shapeConfiguration) {
        return new Shape(startPair, endPair, shapeConfiguration);
    }
}
