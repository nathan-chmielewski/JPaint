package model.shapes;

import model.clickHandler.Pair;
import model.interfaces.IDrawShapeStrategy;
import model.interfaces.IShape;

import java.awt.*;

// Shape class to hold pairs and shape configuration of each IShape object
// Setters and Getters used for shape selection and modification (move)
// Includes deep copy method and draw method

class Shape implements IShape {
    private Pair startPair;
    private Pair endPair;
    private ShapeConfiguration shapeConfiguration;

    Shape(Pair startPair, Pair endPair, ShapeConfiguration shapeConfiguration) {
        this.startPair = startPair;
        this.endPair = endPair;
        this.shapeConfiguration = shapeConfiguration;
    }

    @Override
    public Pair getStartPair() {
        return startPair;
    }

    @Override
    public Pair getEndPair() {
        return endPair;
    }

    @Override
    public ShapeConfiguration getShapeConfiguration() {
        return shapeConfiguration;
    }

    @Override
    public void setStartPair(Pair startPair) {
        this.startPair = startPair;
    }

    @Override
    public void setEndPair(Pair endPair) {
        this.endPair = endPair;
    }

    @Override
    public IShape deepCopy() {
        return new Shape(new Pair(this.startPair.getX(), this.startPair.getY()),
                new Pair(this.endPair.getX(), this.endPair.getY()),
                shapeConfiguration.deepCopy());
    }

    @Override
    public void draw(Graphics2D graphics2D, IDrawShapeStrategy drawStrategy) {
        switch (shapeConfiguration.getActiveShapeShadingType()) {
            case FILLED_IN:
                drawStrategy.drawFilledIn(graphics2D, this);
                break;
            case OUTLINE:
                drawStrategy.drawOutline(graphics2D, this);
                break;
            case OUTLINE_AND_FILLED_IN:
                drawStrategy.drawOutline(graphics2D, this);
                drawStrategy.drawFilledIn(graphics2D, this);
                break;
            default:
                throw new Error("Error in shape shading.");
        }
    }
}
