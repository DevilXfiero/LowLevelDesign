package ElevatorSystem.Elevator;

public class ElevatorCar {
    int id;
    int currentFloor;
    public int nextFloorStoppage;
    public ElevatorDirection elevatorDirection;
    public ElevatorDoor elevatorDoor;

    public ElevatorCar(int id) {
        this.id = id;
        this.currentFloor = 0;
        this.elevatorDirection = ElevatorDirection.IDLE;
        this.elevatorDoor = new ElevatorDoor();
    }

    public void showDisplay() {
        System.out.println("elevator:" + id + " Current floor: " + currentFloor + " going: " + elevatorDirection);
    }

    public void moveElevator(int destinationFloor) {

        this.nextFloorStoppage = destinationFloor;
        if (this.currentFloor == nextFloorStoppage) {
            elevatorDoor.openDoor(id);
            return;
        }


        int startFloor = this.currentFloor;
        elevatorDoor.closeDoor(id);

        if(nextFloorStoppage >= startFloor) {
            this.elevatorDirection = ElevatorDirection.UP;
            showDisplay();


            for(int i=startFloor+1; i<=nextFloorStoppage; i++) {
                try {
                    Thread.sleep(5);
                } catch (Exception e) {

                }
                setCurrentFloor(i);
                showDisplay();
            }

        } else {
            this.elevatorDirection = ElevatorDirection.DOWN;
            showDisplay();

            for(int i=startFloor-1; i>=nextFloorStoppage; i--) {
                try {
                    Thread.sleep(5);
                } catch (Exception e) {

                }
                setCurrentFloor(i);
                showDisplay();
            }
        }

        elevatorDoor.openDoor(id);
    }

    public void setCurrentFloor(int floor) {
        this.currentFloor = floor;
    }



}
