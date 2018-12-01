package pl.sda.medium;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class BankAccountTests {
    private BankAccount bankAccount;

    @Before
    public void setUp() {
        bankAccount = new BankAccount(100);
    }

    /**
     * Rozwiazanie zadania 12
     * Test negatywnego przypadku uzycia oraz przypadu krancowego (0)
     */
    @Test(expected = IllegalArgumentException.class)
    @Parameters({ "-100.0", "0.0" })
    public void shouldThrowExceptionWhenUserTriesToDepositNegativeAmountOfMoney(double invalidAmountToDeposit) {
        bankAccount.deposit(invalidAmountToDeposit);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenUserTriesToWithdrawMoreMoneyThanHeHas() {
        final double amountToWithdraw = 200;
        bankAccount.withdraw(200);
    }
}
