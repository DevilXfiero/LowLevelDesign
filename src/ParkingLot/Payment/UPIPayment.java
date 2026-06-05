package ParkingLot.Payment;

public class UPIPayment implements Payment{
    @Override
    public boolean pay(double price) {
        System.out.println("UPI Payment successful");
        return true;
    }
}
