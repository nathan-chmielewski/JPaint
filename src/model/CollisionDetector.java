package model;

import model.clickHandler.Pair;
import model.interfaces.IShape;

// Collision detector class with static method to determine if Shape objects are within
// selection bounds from mouse click and drag

public class CollisionDetector {

    public static boolean detectCollision(IShape shape, Pair selectionStartPair, Pair selectionEndPair) {
        Pair shapeStartPair = shape.getStartPair();
        Pair shapeEndPair = shape.getEndPair();
        int shapeWidth = shapeEndPair.getX() - shapeStartPair.getX();
        int shapeHeight = shapeEndPair.getY() - shapeStartPair.getY();

        int selectionStartX = selectionStartPair.getX();
        int selectionEndX = selectionEndPair.getX();
        int selectionStartY = selectionStartPair.getY();
        int selectionEndY = selectionEndPair.getY();
        int selectionWidth = selectionEndX - selectionStartX;
        int selectionHeight = selectionEndY - selectionStartY;

        boolean collision = selectionStartX <= shapeStartPair.getX() + shapeWidth &&
                selectionStartX + selectionWidth >= shapeStartPair.getX() &&
                selectionStartY <= shapeStartPair.getY() + shapeHeight &&
                selectionHeight + selectionStartY >= shapeStartPair.getY();
        return collision;
    }
}
