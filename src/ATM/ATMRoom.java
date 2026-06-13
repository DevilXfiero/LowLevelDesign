package ATM;


public class ATMRoom {
    ATM atm;
    User user;


    public void initialize() {

        //create ATM
        atm = ATM.getATMObject();
        atm.setTotalBalance(3500);

        //create User
        this.user = createUser();
    }

    private User createUser(){
        BankAccount account = new BankAccount(2000);
        User user = new User("DevilX", new Card(1234, 344, account), account);
        return user;
    }


}
