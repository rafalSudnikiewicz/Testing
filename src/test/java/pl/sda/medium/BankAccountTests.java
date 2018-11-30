package pl.sda.medium;

import org.junit.Before;
import org.junit.Test;

public class BankAccountTests {
    private BankAccount bankAccount;

    @Before
    public void setUp() {
        bankAccount = new BankAccount(100);
    }

    @Test(expected = IllegalStateException.class)
    public void shouldThrowExceptionWhenUserTriesToWithdrawMoreMoneyThanHeHas() {
        final double amountToWithdraw = 200;
        bankAccount.withdraw(200);
    }
}
