package ElevatorSystem;

import ElevatorSystem.Elevator.ElevatorController;
import ElevatorSystem.Elevator.ElevatorDirection;

import java.util.List;

public class NearestElevatorStrategy implements ElevatorSelectionStrategy{

    @Override
    public ElevatorController getElevator(List<ElevatorController> controllers, int floor, ElevatorDirection direction) {
        ElevatorController nearestController = null;
        int minDistance = Integer.MAX_VALUE;

        for (ElevatorController controller : controllers) {
            int nextFloor = controller.elevatorCar.nextFloorStoppage;

            int dist = Math.abs(nextFloor-floor);

            boolean sameDirection = (controller.elevatorCar.elevatorDirection == direction) &&
                    ((controller.elevatorCar.elevatorDirection == ElevatorDirection.UP && nextFloor >= floor) ||
                    ((controller.elevatorCar.elevatorDirection == ElevatorDirection.DOWN && nextFloor <= floor)));

            if(sameDirection && dist < minDistance) {
                minDistance = dist;
                nearestController = controller;
            }

        }

        // pick from idle elevator
        if(nearestController == null) {
            for(ElevatorController controller: controllers) {
                if(controller.elevatorCar.elevatorDirection == ElevatorDirection.IDLE) {
                    nearestController = controller;
                    break;
                }
            }
        }


        if(nearestController == null) {
            nearestController = controllers.get(0);
        }

        return nearestController;
    }
}
