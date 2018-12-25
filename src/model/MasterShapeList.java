package model;

import model.interfaces.IShape;
import model.interfaces.IDrawObserver;
import model.interfaces.IDrawSubject;
import model.interfaces.IShapeList;

import java.util.ArrayList;

// Master shape list class holds all shapes that are currently represented on the canvas
// Implements Subject. ShapeDrawer registered as Observer

public class MasterShapeList implements IDrawSubject {

    private ArrayList<IShape> shapeList;
    private ArrayList<IDrawObserver> observers;

    public MasterShapeList() {
        shapeList = new ArrayList<>();
        observers = new ArrayList<>();
    }

    public void add(IShape shape) {
        shapeList.add(shape);
        notifyObservers();
    }

    public void remove(IShape shape) {
        shapeList.remove(shape);
        notifyObservers();
    }

    public void shapesModified() {
        notifyObservers();
    }

    @Override
    public void registerObserver(IDrawObserver o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(IDrawObserver o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (IDrawObserver o : observers) {
            o.update(shapeList);
        }
    }

    public ArrayList<IShape> getShapeList() {
        return shapeList;
    }
}
