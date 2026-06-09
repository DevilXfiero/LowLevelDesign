package ElevatorSystem;

import ElevatorSystem.Elevator.ElevatorDirection;

public class Floor {
    public int floorNumber;
    public ExternalButton upButton;
    public ExternalButton downButton;

    public Floor(int floorNumber, ExternalDispatcher externalDispatcher) {
        this.floorNumber = floorNumber;
        this.upButton = new ExternalButton(externalDispatcher);
        this.downButton = new ExternalButton(externalDispatcher);
    }

    public void pressUpButton() {
        upButton.press(floorNumber, ElevatorDirection.UP);
    }

    public void pressDownButton() {
        downButton.press(floorNumber, ElevatorDirection.DOWN);
    }
}
