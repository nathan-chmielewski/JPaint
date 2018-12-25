package main;

import controller.IJPaintController;
import controller.JPaintController;
import model.*;
import model.clickHandler.clickHandler;
import model.interfaces.IShapeList;
import model.persistence.ApplicationState;
import model.draw.ShapeDrawer;
import view.gui.Gui;
import view.gui.GuiWindow;
import view.gui.PaintCanvas;
import view.interfaces.IGuiWindow;
import view.interfaces.IUiModule;


public class Main {
    public static void main(String[] args) {
        PaintCanvas canvas = new PaintCanvas();
        IGuiWindow guiWindow = new GuiWindow(canvas);
        IUiModule uiModule = new Gui(guiWindow);
        ApplicationState appState = new ApplicationState(uiModule);

        MasterShapeList masterShapeList = new MasterShapeList();
        IShapeList selectedShapeList = new ShapeList();
        IShapeList clipboardShapeList = new ShapeList();
        ShapeDrawer shapeDrawer = new ShapeDrawer(canvas);
        ShapeListManager shapeListManager = new ShapeListManager(masterShapeList, selectedShapeList, clipboardShapeList);
        clickHandler clickHandler = new clickHandler(appState, shapeListManager);

        IJPaintController controller = new JPaintController(uiModule, appState, shapeListManager);

        controller.setup();
        masterShapeList.registerObserver(shapeDrawer);
        canvas.addMouseListener(clickHandler);
    }
}