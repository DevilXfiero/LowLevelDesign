package ATM;

public enum TransactionType {
    WITHDRAW,
    CHECK_BALANCE;

    public void showAllTransactionType() {
        for(TransactionType type: TransactionType.values()) {
            System.out.println(type.name());
        }
    }
}
