package ATM;


public class HasCardState extends ATMState {

    @Override
    public void authenticate(ATM atm, Card card, int pin) {
        if(card.getPin() != pin) {
            System.out.println("Incorrect PIN entered");
            exit(atm);
        }

        System.out.println("Authenticated");
        atm.setState(new SelectOperationState());
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
