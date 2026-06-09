package CarRentalSystem;

import CarRentalSystem.Bill.Bill;

import java.util.concurrent.atomic.AtomicInteger;

public class Payment {
    int id;
    int billId;
    double amountPaid;
    private final AtomicInteger paymentIdGenerator = new AtomicInteger(5000);

    public Payment(int id, int billId, double amountPaid) {
        this.id = id;
        this.billId = billId;
        this.amountPaid = amountPaid;
    }

    public Payment makePayment(Bill bill) {
        Payment payment = new Payment(
                paymentIdGenerator.getAndIncrement(),
                bill.getId(),
                bill.getBillAmount()
        );

        bill.setPaid(true);
        return payment;
    }
}
