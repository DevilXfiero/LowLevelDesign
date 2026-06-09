package ElevatorSystem;

import ElevatorSystem.Elevator.ElevatorController;
import ElevatorSystem.Elevator.ElevatorDirection;

import java.util.List;

public interface ElevatorSelectionStrategy {
    ElevatorController getElevator(List<ElevatorController> controllers, int floor, ElevatorDirection direction);
}
