package ElevatorSystem.Elevator;

import java.util.concurrent.PriorityBlockingQueue;

public class ElevatorController implements Runnable {
    public ElevatorCar elevatorCar;
    PriorityBlockingQueue<Integer> upMinPQ;
    PriorityBlockingQueue<Integer> downMaxPQ;

    private final Object monitor = new Object();


    public ElevatorController (ElevatorCar elevatorCar) {
        this.elevatorCar = elevatorCar;
        this.upMinPQ = new PriorityBlockingQueue<>();
        this.downMaxPQ = new PriorityBlockingQueue<>(10, (a, b) -> b - a);
    }

    public void submitRequest(int destination) {
        System.out.println("Received request for floor: " + destination + " by elevator: " + elevatorCar.id);

        if(destination == elevatorCar.nextFloorStoppage) {
            return;
        }

        if(destination >= elevatorCar.nextFloorStoppage) {
            if(!upMinPQ.contains(destination)) {
                upMinPQ.offer(destination);
            }
        } else {
            if(!downMaxPQ.contains(destination)) {
                downMaxPQ.offer(destination);
            }
        }

        synchronized (monitor) {
            monitor.notify(); // wake elevator thread
        }
    }


    @Override
    public void run() {
        controlElevator();
    }

    public void controlElevator() {
        while(true) {
            if(upMinPQ.isEmpty() && downMaxPQ.isEmpty()) {
                synchronized (monitor) {
                    try {
                        System.out.println("elevator:" + elevatorCar.id + " is IDLE");
                        elevatorCar.elevatorDirection = ElevatorDirection.IDLE;
                        monitor.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }

            while(!upMinPQ.isEmpty()) {
                int floor = upMinPQ.poll();
                System.out.println("Serving floor: " + floor + " by elevator:" + elevatorCar.id + " currentFloor: " + elevatorCar.currentFloor);
                elevatorCar.moveElevator(floor);
            }

            while(!downMaxPQ.isEmpty()) {
                int floor = downMaxPQ.poll();
                System.out.println("Serving floor: " + floor + " by elevator:" + elevatorCar.id + " currentFloor: " + elevatorCar.currentFloor);
                elevatorCar.moveElevator(floor);
            }
        }
    }
}
