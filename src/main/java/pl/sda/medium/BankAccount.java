package pl.sda.medium;

public class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        balance = initialBalance;
    }

    public void deposit(double amountToDeposit) {
        balance += amountToDeposit;
    }

    /**
     * Uzytkownik nie powinien moc wyplacic wiecej pieniedzy niz ma na koncie!
     */
    public void withdraw(double amountToWithdraw) {
        if(balance - amountToWithdraw < 0) {
            String errorMessage = String.format("You don't have enough cash to withdraw %f. Current balance %f",
                                                amountToWithdraw, balance);
            throw new IllegalStateException(errorMessage);
        }
        balance -= amountToWithdraw;
    }

    public double getBalance() {
        return balance;
    }
}
