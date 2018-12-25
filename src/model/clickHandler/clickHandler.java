package model.clickHandler;


import model.ShapeListManager;
import model.commands.DrawShapeCommand;
import model.commands.MoveShapeCommand;
import model.commands.SelectShapeCommand;
import model.interfaces.ICommand;
import model.persistence.ApplicationState;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

//ClickHandler class to build mouse functions, create commands for Draw, Select, and Move

public class clickHandler extends MouseAdapter {
    private Pair startPair;
    private Pair endPair;
    private ApplicationState appState;
    private ShapeListManager shapeListManager;


    public clickHandler(ApplicationState appState, ShapeListManager shapeListManager) {
        this.appState = appState;
        this.shapeListManager = shapeListManager;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        startPair = new Pair(e.getX(), e.getY());
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        endPair = new Pair(e.getX(), e.getY());

        /* assign topLeft and bottomRight pairs to be able to
        click and drag in any direction to create a shape
         */
        Pair topLeft = new Pair(Integer.min(startPair.getX(), endPair.getX()),
                                    Integer.min(startPair.getY(), endPair.getY()));
        Pair bottomRight = new Pair(Integer.max(startPair.getX(), endPair.getX()),
                                    Integer.max(startPair.getY(), endPair.getY()));
        ICommand command;
        switch(appState.getActiveStartAndEndPointMode()) {
            case DRAW:
                command = new DrawShapeCommand(shapeListManager, appState, topLeft, bottomRight);
                break;
            case SELECT:
                shapeListManager.getSelectedShapeList().getShapeList().clear();
                command = new SelectShapeCommand(shapeListManager, topLeft, bottomRight);
                break;
            case MOVE:
                command = new MoveShapeCommand(shapeListManager, startPair, endPair);
                break;
            default:
                command = new DrawShapeCommand(shapeListManager, appState, topLeft, bottomRight);
        }
        command.run();
    }
}
