package ElevatorSystem;

import ElevatorSystem.Elevator.ElevatorController;

public class InternalButton {
    public ElevatorController elevatorController;

    public InternalButton(ElevatorController elevatorController) {
        this.elevatorController = elevatorController;
    }

    public void press(int floor) {
        elevatorController.submitRequest(floor);
    }
}
