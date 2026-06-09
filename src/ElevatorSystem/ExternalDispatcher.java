package ElevatorSystem;

import ElevatorSystem.Elevator.ElevatorController;
import ElevatorSystem.Elevator.ElevatorDirection;

public class ExternalDispatcher {
    public ElevatorScheduler elevatorScheduler;

    public ExternalDispatcher(ElevatorScheduler elevatorScheduler) {
        this.elevatorScheduler = elevatorScheduler;
    }

    public void submitExternalRequest(int floor, ElevatorDirection direction) {
        ElevatorController controller = elevatorScheduler.assignElevator(floor, direction);
        controller.submitRequest(floor);
    }
}
