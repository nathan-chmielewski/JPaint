package model.interfaces;

import model.interfaces.IShape;

import java.util.ArrayList;

public interface IDrawObserver {
    void update(ArrayList<IShape> shapeList);
}
