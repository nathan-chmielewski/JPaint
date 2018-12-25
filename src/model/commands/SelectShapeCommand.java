package model.commands;

import model.CollisionDetector;
import model.MasterShapeList;
import model.clickHandler.Pair;
import model.ShapeListManager;
import model.interfaces.ICommand;
import model.interfaces.IShape;
import model.interfaces.IShapeList;

// Select Shape command uses CollisionDetector class to determine shapes to add
// from master shape list to selected shape list in order to perform move, copy, paste, delete

public class SelectShapeCommand implements ICommand {
    private MasterShapeList masterShapeList;
    private IShapeList selectedShapeList;
    private Pair selectionStartPair;
    private Pair selectionEndPair;

    public SelectShapeCommand(ShapeListManager shapeListManager, Pair selectionStartPair, Pair selectionEndPair) {
        this.masterShapeList = shapeListManager.getMasterShapeList();
        this.selectedShapeList = shapeListManager.getSelectedShapeList();
        this.selectionStartPair = selectionStartPair;
        this.selectionEndPair = selectionEndPair;
    }

    public void run() {
        for(IShape s : masterShapeList.getShapeList()) {
            if (CollisionDetector.detectCollision(s, selectionStartPair, selectionEndPair)) {
                selectedShapeList.add(s);
            }
        }
    }
}
