package ATM;

public class SelectOperationState extends ATMState {


    @Override
    public void selectOperation(ATM atm, Card card, TransactionType txnType) {
       switch (txnType) {
           case TransactionType.CHECK_BALANCE:
               atm.setState(new CheckBalanceState());
               break;
           case TransactionType.WITHDRAW:
               atm.setState(new CashWithdrawState());
               break;
           default:
               System.out.println("Invalid State");
               exit(atm);
       }
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
