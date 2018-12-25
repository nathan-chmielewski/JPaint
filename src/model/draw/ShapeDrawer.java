package model.draw;

import model.interfaces.IDrawShapeStrategy;
import model.interfaces.IShape;
import model.interfaces.IDrawObserver;
import view.gui.PaintCanvas;

import java.util.ArrayList;

// Registered to MasterShapeList Subject. Iterates through master shape list
// Calls each IShape's draw method to draw object to canvas

public class ShapeDrawer implements IDrawObserver {
    private PaintCanvas canvas;

    public ShapeDrawer(PaintCanvas canvas) {
        this.canvas = canvas;
    }

    @Override
    public void update(ArrayList<IShape> shapeList) {
        ClearCanvas.clearCanvas(canvas);
        for(IShape s: shapeList) {
            IDrawShapeStrategy drawStrategy;
            switch(s.getShapeConfiguration().getActiveShapeType()) {
                case ELLIPSE:
                    drawStrategy = IDrawShapeStrategyFactory.createDrawEllipseStrategy();
                    break;
                case RECTANGLE:
                    drawStrategy = IDrawShapeStrategyFactory.createDrawRectangleStrategy();
                    break;
                case TRIANGLE:
                    drawStrategy = IDrawShapeStrategyFactory.createDrawTriangleStrategy();
                    break;
                default:
                    throw new Error("Error in drawing shape.");
            }
            s.draw(canvas.getGraphics2D(), drawStrategy);
        }
    }
}
