package controller;

import model.ShapeListManager;
import model.commands.*;
import model.interfaces.IApplicationState;
import view.EventName;
import view.interfaces.IUiModule;

public class JPaintController implements IJPaintController {
    private final IUiModule uiModule;
    private final IApplicationState applicationState;
    private ShapeListManager shapeListManager;

    public JPaintController(IUiModule uiModule, IApplicationState applicationState, ShapeListManager shapeListManager) {
        this.uiModule = uiModule;
        this.applicationState = applicationState;
        this.shapeListManager = shapeListManager;
    }

    @Override
    public void setup() {
        setupEvents();
    }

    private void setupEvents() {
        uiModule.addEvent(EventName.CHOOSE_SHAPE, () -> applicationState.setActiveShape());
        uiModule.addEvent(EventName.CHOOSE_PRIMARY_COLOR, () -> applicationState.setActivePrimaryColor());
        uiModule.addEvent(EventName.CHOOSE_SECONDARY_COLOR, () -> applicationState.setActiveSecondaryColor());
        uiModule.addEvent(EventName.CHOOSE_SHADING_TYPE, () -> applicationState.setActiveShadingType());
        uiModule.addEvent(EventName.CHOOSE_START_POINT_ENDPOINT_MODE, () -> applicationState.setActiveStartAndEndPointMode());
        uiModule.addEvent(EventName.UNDO, () -> new UndoCommand().run());
        uiModule.addEvent(EventName.REDO, () -> new RedoCommand().run());
        uiModule.addEvent(EventName.COPY, () -> new CopyShapeCommand(shapeListManager).run());
        uiModule.addEvent(EventName.PASTE, () -> new PasteShapeCommand(shapeListManager).run());
        uiModule.addEvent(EventName.DELETE, () -> new DeleteShapeCommand(shapeListManager).run());

    }
}
