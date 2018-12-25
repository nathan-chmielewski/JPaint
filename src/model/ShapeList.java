package model;

import model.interfaces.*;

import java.util.ArrayList;

public class ShapeList implements IShapeList {
    private ArrayList<IShape> shapeList;

    public ShapeList() {
        this.shapeList = new ArrayList<>();
    }

    @Override
    public void add(IShape shape) {
        shapeList.add(shape);
    }

    @Override
    public void remove(IShape shape) {
        shapeList.remove(shape);
    }

    @Override
    public ArrayList<IShape> getShapeList() {
        return shapeList;
    }
}
