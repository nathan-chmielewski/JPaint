package model.commands;

import model.MasterShapeList;
import model.ShapeListManager;
import model.interfaces.ICommand;
import model.interfaces.IShape;
import model.interfaces.IShapeList;
import model.interfaces.IUndoable;

import java.util.ArrayList;

// Delete shape command to delete selected shapes from master shape list
// Holds local list of shapes deleted for undo and redo commands

public class DeleteShapeCommand implements ICommand, IUndoable {
    private MasterShapeList masterShapeList;
    private IShapeList selectedShapeList;
    private ArrayList<IShape> localShapeList = new ArrayList<>();


    public DeleteShapeCommand(ShapeListManager shapeListManager) {
        this.masterShapeList = shapeListManager.getMasterShapeList();
        this.selectedShapeList = shapeListManager.getSelectedShapeList();
    }

    @Override
    public void run() {
        if (!selectedShapeList.getShapeList().isEmpty()) {
            for (IShape s : selectedShapeList.getShapeList()) {
                masterShapeList.remove(s);
                masterShapeList.shapesModified();
                localShapeList.add(s);
            }
            CommandHistory.add(this);
            selectedShapeList.getShapeList().clear();
        }
    }

    @Override
    public void undo() {
        if (!localShapeList.isEmpty()) {
            for (IShape s : localShapeList) {
                masterShapeList.add(s);
            }
        }
    }

    @Override
    public void redo() {
        if (!localShapeList.isEmpty()) {
            for (IShape s : localShapeList) {
                masterShapeList.remove(s);
            }
        }
    }
}
