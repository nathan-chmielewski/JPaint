package model.commands;

import model.*;
import model.clickHandler.Pair;
import model.interfaces.ICommand;
import model.interfaces.IShape;
import model.interfaces.IShapeList;
import model.interfaces.IUndoable;
import model.persistence.ApplicationState;
import model.shapes.IShapeFactory;
import model.shapes.ShapeConfiguration;

// Draw shape command to use IShapeFactory static factory to create shapes
// Holds local shape reference of last shape drawn for undo, redo commands
// Requires pairs from mouse click and drag, and Application State for ShapeConfiguration object
// as shape parameters

public class DrawShapeCommand implements ICommand, IUndoable {
    private MasterShapeList masterShapeList;
    private IShapeList selectedShapeList;
    private ApplicationState appState;
    private Pair startPair;
    private Pair endPair;
    private IShape lastShapeDrawn; // Hold last shape drawn for undo/redo commands

    public DrawShapeCommand(ShapeListManager shapeListManager, ApplicationState appState, Pair startPair, Pair endPair) {
        this.masterShapeList = shapeListManager.getMasterShapeList();
        this.selectedShapeList = shapeListManager.getSelectedShapeList();
        this.appState = appState;
        this.startPair = startPair;
        this.endPair = endPair;
    }

    @Override
    public void run() {
        ShapeConfiguration shapeConfiguration = appState.getCurrentShapeConfiguration();
        IShape shape = IShapeFactory.createShape(startPair, endPair, shapeConfiguration);
        masterShapeList.add(shape);
        lastShapeDrawn = shape;

        CommandHistory.add(this);
    }

    public void undo() {
        masterShapeList.remove(lastShapeDrawn);
        if (!selectedShapeList.getShapeList().isEmpty()) {
            for (int i = 0; i < selectedShapeList.getShapeList().size(); i++) {
                if (selectedShapeList.getShapeList().get(i) == lastShapeDrawn) {
                    selectedShapeList.getShapeList().remove(lastShapeDrawn);
                }
            }
        }
    }

    public void redo() {
        masterShapeList.add(lastShapeDrawn);
    }
}
