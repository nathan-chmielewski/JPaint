package model.interfaces;

import model.interfaces.IShape;

import java.awt.*;

public interface IDrawShapeStrategy {
    void drawOutline(Graphics2D graphics2D, IShape s);
    void drawFilledIn(Graphics2D graphics2D, IShape s);
}
