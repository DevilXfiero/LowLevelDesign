package ElevatorSystem.Elevator;


enum DoorState {
    DOOR_OPEN,
    DOOR_CLOSED
}


public class ElevatorDoor {
    DoorState state;

    ElevatorDoor () {
        this.state = DoorState.DOOR_CLOSED;
    }

    public void openDoor(int id) {
        state = DoorState.DOOR_OPEN;
        System.out.println("Opening the Elevator door of elevator:" + id);
    }

    public void closeDoor(int id) {
        state = DoorState.DOOR_CLOSED;
        System.out.println("Closing the Elevator door of elevator:" + id);
    }
}

