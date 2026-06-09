package ElevatorSystem;

import ElevatorSystem.Elevator.ElevatorController;
import ElevatorSystem.Elevator.ElevatorDirection;

import java.util.List;

public class ElevatorScheduler {

    List<ElevatorController> controllers;
    ElevatorSelectionStrategy strategy;

    public ElevatorScheduler(List<ElevatorController> controllers, ElevatorSelectionStrategy strategy) {
        this.controllers = controllers;
        this.strategy = strategy;
    }

    public ElevatorController assignElevator(int floor, ElevatorDirection direction) {
        return strategy.getElevator(controllers, floor, direction);
    }

}
