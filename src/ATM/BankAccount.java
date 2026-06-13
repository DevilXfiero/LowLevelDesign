package ATM;

import java.util.UUID;

public class BankAccount {
    UUID accountNumber;
    int balance;

    public BankAccount(int balance) {
        this.accountNumber = UUID.randomUUID();
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void addMoney(int amount) {
        balance += amount;
    }

    public void deductMoney(int amount) {
        balance -= amount;
    }
}
