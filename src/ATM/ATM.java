package ATM;

public class ATM {
    private static ATM atmObject = new ATM(); // eager intialization
    ATMState state;
    int totalBalance;
    int noOf2kNotes;
    int noOf500Notes;
    int noOf100Notes;

    public ATM() {
        this.state = new IdleState();
        this.totalBalance = 0;
        this.noOf2kNotes = 0;
        this.noOf100Notes = 0;
        this.noOf500Notes = 0;
    }

    public static ATM getATMObject() {
        atmObject.setState(new IdleState());
        return atmObject;
    }


    public void printCurrentATMStatus(){
        System.out.println("Balance: " + totalBalance);

    }

    public void setMoney(int totalBalance, int noOf2kNotes, int noOf500Notes, int noOf100Notes) {
        this.totalBalance = totalBalance;
        this.noOf2kNotes = noOf2kNotes;
        this.noOf500Notes = noOf500Notes;
        this.noOf100Notes = noOf100Notes;
    }

    public ATMState getState() {
        return state;
    }

    public void setState(ATMState state) {
        this.state = state;
    }

    public int getTotalBalance() {
        return totalBalance;
    }

    public void setTotalBalance(int totalBalance) {
        this.totalBalance = totalBalance;
    }

    public int getNoOf2kNotes() {
        return noOf2kNotes;
    }

    public void setNoOf2kNotes(int noOf2kNotes) {
        this.noOf2kNotes = noOf2kNotes;
    }

    public int getNoOf500Notes() {
        return noOf500Notes;
    }

    public void setNoOf500Notes(int noOf500Notes) {
        this.noOf500Notes = noOf500Notes;
    }

    public int getNoOf100Notes() {
        return noOf100Notes;
    }

    public void setNoOf100Notes(int noOf100Notes) {
        this.noOf100Notes = noOf100Notes;
    }
}
