package ATM;

import java.util.UUID;

public class Card {
    UUID cardId;
    int pin;
    int cvv;
    BankAccount account;

    public Card(int pin, int cvv, BankAccount account) {
        this.cardId = UUID.randomUUID();
        this.pin = pin;
        this.cvv = cvv;
        this.account = account;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public int getCvv() {
        return cvv;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    public BankAccount getAccount() {
        return account;
    }

    public void setAccount(BankAccount account) {
        this.account = account;
    }
}
