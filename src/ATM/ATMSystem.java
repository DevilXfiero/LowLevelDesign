package ATM;

public class ATMSystem {
    static void main() {
        ATMRoom atmRoom = new ATMRoom();
        atmRoom.initialize();

        atmRoom.atm.printCurrentATMStatus();
        atmRoom.atm.state.insertCard(atmRoom.atm, atmRoom.user.card);
        atmRoom.atm.state.authenticate(atmRoom.atm, atmRoom.user.card, 1234);
        atmRoom.atm.state.selectOperation(atmRoom.atm, atmRoom.user.card, TransactionType.WITHDRAW);
        atmRoom.atm.state.withdraw(atmRoom.atm, atmRoom.user.card, 1000);
        atmRoom.atm.printCurrentATMStatus();

    }

}
