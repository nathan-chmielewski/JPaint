package model.interfaces;

import java.util.ArrayList;

public interface IShapeList {
    void add(IShape shape);

    void remove(IShape shape);

    ArrayList<IShape> getShapeList();
}
