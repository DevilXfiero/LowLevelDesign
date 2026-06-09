package CarRentalSystem.Bill;

public class Bill {
    int id;
    int reservationId;
    double billAmount;
    boolean isPaid = false;

    public Bill(int id, int reservationId, double billAmount) {
        this.id = id;
        this.reservationId = reservationId;
        this.billAmount = billAmount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getReservationId() {
        return reservationId;
    }

    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
    }

    public double getBillAmount() {
        return billAmount;
    }

    public void setBillAmount(double billAmount) {
        this.billAmount = billAmount;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }
}
