package model.shapes;

import java.awt.*;
import java.util.EnumMap;

public class ShapeColorMap {
    private static EnumMap<ShapeColor, Color> map = new EnumMap<>(ShapeColor.class);
    private static ShapeColorMap instance = new ShapeColorMap();

    private ShapeColorMap() {
        map.put(ShapeColor.BLACK, Color.BLACK);
        map.put(ShapeColor.BLUE, Color.BLUE);
        map.put(ShapeColor.CYAN, Color.CYAN);
        map.put(ShapeColor.DARK_GRAY, Color.DARK_GRAY);
        map.put(ShapeColor.GRAY, Color.GRAY);
        map.put(ShapeColor.GREEN, Color.GREEN);
        map.put(ShapeColor.LIGHT_GRAY, Color.LIGHT_GRAY);
        map.put(ShapeColor.MAGENTA, Color.MAGENTA);
        map.put(ShapeColor.ORANGE, Color.ORANGE);
        map.put(ShapeColor.PINK, Color.PINK);
        map.put(ShapeColor.RED, Color.RED);
        map.put(ShapeColor.WHITE, Color.WHITE);
        map.put(ShapeColor.YELLOW, Color.YELLOW);
    }

    public static Color getMappingForShapeColor(ShapeColor shapeColor) {
        return instance.get(shapeColor);
    }

    private Color get(ShapeColor shapeColor) {
        return map.get(shapeColor);
    }
}
