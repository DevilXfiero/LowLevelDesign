package MovieTicketBookingApp;

import java.util.UUID;

public class Payment {
    UUID paymentId;
    PaymentStatus status;

    public Payment(PaymentStatus status) {
        this.paymentId = UUID.randomUUID();
        this.status = status;
    }

    public UUID getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(UUID paymentId) {
        this.paymentId = paymentId;
    }

    public PaymentStatus getStatus() {
        return status;
    }

    public void setStatus(PaymentStatus status) {
        this.status = status;
    }
}
