package ATM;

public class CashWithdrawState extends ATMState {
    @Override
    public void withdraw(ATM atm, Card card, int amount) {
        if(atm.getTotalBalance() < amount) {
            System.out.println("Insufficient funds in ATM");
            exit(atm);
        }

        if(card.getAccount().getBalance() < amount) {
            System.out.println("Insufficient balance in account");
            exit(atm);
        }

        card.getAccount().deductMoney(card.getAccount().getBalance()-amount);
        atm.setTotalBalance(atm.getTotalBalance()-amount);
        System.out.println("Transaction succesful");
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
