package model.commands;

import model.ShapeListManager;
import model.interfaces.ICommand;
import model.interfaces.IShape;
import model.interfaces.IShapeList;

// Copy shape command to create deep copy of selected shape list IShape objects
// to clipboard shape list

public class CopyShapeCommand implements ICommand {
    private IShapeList selectedShapeList;
    private IShapeList clipboardShapeList;


    public CopyShapeCommand(ShapeListManager shapeListManager) {
        this.selectedShapeList = shapeListManager.getSelectedShapeList();
        this.clipboardShapeList = shapeListManager.getClipboardShapeList();
    }

    @Override
    public void run() {
        clipboardShapeList.getShapeList().clear();
        for (IShape s : selectedShapeList.getShapeList()) {
            clipboardShapeList.add(s.deepCopy());
        }
    }
}
