package model.commands;

import model.MasterShapeList;
import model.clickHandler.Pair;
import model.ShapeListManager;
import model.interfaces.ICommand;
import model.interfaces.IShape;
import model.interfaces.IShapeList;
import model.interfaces.IUndoable;

import java.util.ArrayList;

// Paste shape command to add deep copies of clipboard shape list to master shape list
// Local shape list, pastedShapes, stores deep copy of shapes for undo, redo commands

public class PasteShapeCommand implements ICommand, IUndoable {
    private MasterShapeList masterShapeList;
    private IShapeList clipboardShapeList;
    private ArrayList<IShape> pastedShapes;


    public PasteShapeCommand(ShapeListManager shapeListManager) {
        this.masterShapeList = shapeListManager.getMasterShapeList();
        this.clipboardShapeList = shapeListManager.getClipboardShapeList();
        pastedShapes = new ArrayList<>();
    }

    @Override
    public void run() {
        if(!clipboardShapeList.getShapeList().isEmpty()) {
            for (IShape s : clipboardShapeList.getShapeList()) {
                IShape pastedShape = s.deepCopy();
                pastedShape.setStartPair(new Pair(s.getStartPair().getX() + 40, s.getStartPair().getY()));
                pastedShape.setEndPair(new Pair(s.getEndPair().getX() + 40, s.getEndPair().getY()));
                masterShapeList.add(pastedShape);
                pastedShapes.add(pastedShape);
            }
            CommandHistory.add(this);
        }
    }

    @Override
    public void undo() {
        for (IShape s : pastedShapes) {
            masterShapeList.remove(s);
        }
    }

    @Override
    public void redo() {
        for (IShape s : pastedShapes) {
            masterShapeList.add(s);
        }
    }
}
