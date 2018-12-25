package model.shapes;

import model.draw.StartAndEndPointMode;

// Shape Configuration class to simplify instantiation of Shape objects
// Holds Application State options for each shape

public class ShapeConfiguration {
    private ShapeType activeShapeType;
    private ShapeColor activePrimaryColor;
    private ShapeColor activeSecondaryColor;
    private ShapeShadingType activeShapeShadingType;
    private StartAndEndPointMode activeStartAndEndPointMode;

    public ShapeConfiguration(ShapeType activeShapeType, ShapeColor activePrimaryColor,
                              ShapeColor activeSecondaryColor, ShapeShadingType activeShapeShadingType,
                              StartAndEndPointMode activeStartAndEndPointMode) {
        this.activeShapeType = activeShapeType;
        this.activePrimaryColor = activePrimaryColor;
        this.activeSecondaryColor = activeSecondaryColor;
        this.activeShapeShadingType = activeShapeShadingType;
        this.activeStartAndEndPointMode = activeStartAndEndPointMode;
    }

    public ShapeType getActiveShapeType() {
        return activeShapeType;
    }

    public ShapeColor getActivePrimaryColor() {
        return activePrimaryColor;
    }

    public ShapeColor getActiveSecondaryColor() {
        return activeSecondaryColor;
    }

    public ShapeShadingType getActiveShapeShadingType() {
        return activeShapeShadingType;
    }

    public StartAndEndPointMode getActiveStartAndEndPointMode() {
        return activeStartAndEndPointMode;
    }

    public ShapeConfiguration deepCopy() {
        return new ShapeConfiguration(this.activeShapeType, this.activePrimaryColor, this.activeSecondaryColor,
                                        this.activeShapeShadingType, this.activeStartAndEndPointMode);
    }
}
