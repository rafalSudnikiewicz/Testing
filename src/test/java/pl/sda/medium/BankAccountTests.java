package pl.sda.medium;

import org.junit.Before;
import org.junit.Test;

public class BankAccountTests {
    private BankAccount bankAccount;

    @Before
    public void setUp() {
        bankAccount = new BankAccount(100);
    }

    @Test
    public void shouldThrowExceptionWhenUserTriesToWithdrawMoreMoneyThanHeHas() {
        bankAccount.withdraw(200);
    }
}
