package model.commands;

import model.MasterShapeList;
import model.clickHandler.Pair;
import model.ShapeListManager;
import model.interfaces.ICommand;
import model.interfaces.IShape;
import model.interfaces.IShapeList;
import model.interfaces.IUndoable;

import java.util.ArrayList;

// Move shape command to modify selected shapes in master shape list
// Holds local reference to shapes for undo and redo commands
// Requires pairs from mouse click and drag to determine X and Y deltas

public class MoveShapeCommand implements ICommand, IUndoable {
    private MasterShapeList masterShapeList;
    private IShapeList selectedShapeList;
    private ArrayList<IShape> localShapeList = new ArrayList<>();
    private int deltaX;
    private int deltaY;

    public MoveShapeCommand(ShapeListManager shapeListManager, Pair moveStartPair, Pair moveEndPair) {
        this.masterShapeList = shapeListManager.getMasterShapeList();
        this.selectedShapeList = shapeListManager.getSelectedShapeList();
        this.deltaX = moveEndPair.getX() - moveStartPair.getX();
        this.deltaY = moveEndPair.getY() - moveStartPair.getY();
    }

    public void run() {
        if (!selectedShapeList.getShapeList().isEmpty()) {
            for (IShape s : selectedShapeList.getShapeList()) {
                Pair oldStartPair = s.getStartPair();
                Pair oldEndPair = s.getEndPair();
                s.setStartPair(new Pair(oldStartPair.getX() + deltaX,
                        oldStartPair.getY() + deltaY));
                s.setEndPair(new Pair(oldEndPair.getX() + deltaX,
                        oldEndPair.getY() + deltaY));
                localShapeList.add(s);

            }
            masterShapeList.shapesModified();
            CommandHistory.add(this);
        }
    }

    public void undo() {
        if (!localShapeList.isEmpty()) {
            for (IShape s : localShapeList) {
                Pair oldStartPair = s.getStartPair();
                Pair oldEndPair = s.getEndPair();
                s.setStartPair(new Pair(oldStartPair.getX() - deltaX,
                        oldStartPair.getY() - deltaY));
                s.setEndPair(new Pair(oldEndPair.getX() - deltaX,
                        oldEndPair.getY() - deltaY));
            }
            masterShapeList.shapesModified();
        }
    }

    public void redo() {
        if (!localShapeList.isEmpty()) {
            for (IShape s : localShapeList) {
                Pair oldStartPair = s.getStartPair();
                Pair oldEndPair = s.getEndPair();
                s.setStartPair(new Pair(oldStartPair.getX() + deltaX,
                        oldStartPair.getY() + deltaY));
                s.setEndPair(new Pair(oldEndPair.getX() + deltaX,
                        oldEndPair.getY() + deltaY));
            }
            masterShapeList.shapesModified();
        }
    }
}
