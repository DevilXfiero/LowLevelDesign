package CarRentalSystem;


public class Vehicle {
    int id;
    String vehicleNumber;
    VehicleType type;
    VehicleStatus status;
    double dailyRentalCost;

    public Vehicle(int id, String vehicleNumber, VehicleType vehicleType, double dailyRentalCost) {
        this.id = id;
        this.vehicleNumber = vehicleNumber;
        this.type = vehicleType;
        this.status = VehicleStatus.AVAILABLE;
    }

    public void updateStatus(VehicleStatus status) {
        this.status = status;
    }

    public double getDailyRentalCost() {
        return dailyRentalCost;
    }

    public void setDailyRentalCost(double dailyRentalCost) {
        this.dailyRentalCost = dailyRentalCost;
    }
}
