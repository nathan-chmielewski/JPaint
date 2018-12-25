package model.interfaces;

import model.clickHandler.Pair;
import model.shapes.ShapeConfiguration;

import java.awt.*;

public interface IShape {
    Pair getStartPair();

    Pair getEndPair();

    ShapeConfiguration getShapeConfiguration();

    void setStartPair(Pair newStartPair);

    void setEndPair(Pair newEndPair);

    void draw(Graphics2D graphics2D, IDrawShapeStrategy drawStrategy);

    IShape deepCopy();
}


