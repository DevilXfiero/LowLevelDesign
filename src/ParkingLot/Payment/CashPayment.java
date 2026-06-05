package ParkingLot.Payment;

public class CashPayment implements Payment{

    @Override
    public boolean pay(double price) {
        System.out.println("Cash payment successful");
        return true;
    }
}
