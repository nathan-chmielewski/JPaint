package model;

import model.interfaces.IShapeList;

// ShapeListManager class to simplify passing references of ShapeLists

public class ShapeListManager {
    private MasterShapeList masterShapeList;
    private IShapeList selectedShapeList;
    private IShapeList clipboardShapeList;

    public ShapeListManager(MasterShapeList masterShapeList, IShapeList selectedShapeList,
                            IShapeList clipboardShapeList) {
        this.masterShapeList = masterShapeList;
        this.selectedShapeList = selectedShapeList;
        this.clipboardShapeList = clipboardShapeList;

    }

    public MasterShapeList getMasterShapeList() {
        return masterShapeList;
    }

    public IShapeList getSelectedShapeList() {
        return selectedShapeList;
    }

    public IShapeList getClipboardShapeList() { return clipboardShapeList; }
}
