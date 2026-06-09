package ElevatorSystem;

import ElevatorSystem.Elevator.ElevatorCar;
import ElevatorSystem.Elevator.ElevatorController;

import java.util.List;

public class Demo {

    static void main() throws InterruptedException {

        ElevatorController elevatorController1= new ElevatorController(new ElevatorCar(1));
        ElevatorController elevatorController2 = new ElevatorController(new ElevatorCar(2));

        InternalButton internalButton_for_elevator1 = new InternalButton(elevatorController1);
        InternalButton internalButton_for_elevator2 = new InternalButton(elevatorController1);

        ElevatorSelectionStrategy elevatorSelectionStrategy = new NearestElevatorStrategy();
        ElevatorScheduler elevatorScheduler = new ElevatorScheduler(List.of(elevatorController1, elevatorController2), elevatorSelectionStrategy);

        ExternalDispatcher externalDispatcher = new ExternalDispatcher(elevatorScheduler);

        Building building = new Building(10, externalDispatcher);

        new Thread(elevatorController1, "Elevator-1").start();
        new Thread(elevatorController2, "Elevator-2").start();

        building.getFloor(3).pressUpButton();
        Thread.sleep(5);

        building.getFloor(5).pressDownButton();
        Thread.sleep(5);

        building.getFloor(7).pressDownButton();
        Thread.sleep(5);

        internalButton_for_elevator1.press(4); // user inside elevator 1 presses floor 4
        Thread.sleep(5);

        internalButton_for_elevator1.press(5); // user inside elevator 1 presses floor 5
        Thread.sleep(5);

        building.getFloor(4).pressDownButton();
        Thread.sleep(5);

        building.getFloor(7).pressUpButton();

        internalButton_for_elevator2.press(7);

    }
}
