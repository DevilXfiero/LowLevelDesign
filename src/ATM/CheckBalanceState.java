package ATM;

public class CheckBalanceState extends ATMState {
    @Override
    public void displayBalance(ATM atm, Card card) {
        System.out.println("Your balance is " + card.getAccount().getBalance());
        exit(atm);
    }

    @Override
    public void exit(ATM atm) {
        returnCard();
        atm.setState(new IdleState());
    }

    @Override
    public void returnCard() {
        System.out.println("Please collect your card");
    }
}
