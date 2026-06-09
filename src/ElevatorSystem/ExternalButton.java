package ElevatorSystem;

import ElevatorSystem.Elevator.ElevatorDirection;

public class ExternalButton {
    public ExternalDispatcher externalDispatcher;

    public ExternalButton (ExternalDispatcher externalDispatcher) {
        this.externalDispatcher = externalDispatcher;
    }

    public void press(int floor, ElevatorDirection direction) {
        externalDispatcher.submitExternalRequest(floor, direction);
    }


}
