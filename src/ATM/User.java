package ATM;

public class User {
    String name;
    Card card;
    BankAccount bankAccount;

    public User(String name, Card card, BankAccount bankAccount) {
        this.name = name;
        this.card = card;
        this.bankAccount = bankAccount;
    }
}
