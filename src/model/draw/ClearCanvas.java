package model.draw;

import view.gui.PaintCanvas;

import java.awt.*;

// Class with static method to clear canvas every time ShapeDrawer class is called

public class ClearCanvas {

    public ClearCanvas() { }

    public static void clearCanvas(PaintCanvas canvas) {
        Graphics2D whiteCanvas = canvas.getGraphics2D();
        whiteCanvas.setColor(Color.WHITE);
        whiteCanvas.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
    }
}
