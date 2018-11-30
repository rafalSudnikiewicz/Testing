package pl.sda.medium;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class BankAccountTests {
    private BankAccount bankAccount;

    @Before
    public void setUp() {
        bankAccount = new BankAccount(100);
    }

    @Test
    public void shouldThrowExceptionWhenUserTriesToWithdrawMoreMoneyThanHeHas() {
        final double amountToWithdraw = 200;

        try {
            bankAccount.withdraw(200);
        } catch(IllegalStateException ex) {
            String expectedMessage = String.format("You don't have enough cash to withdraw %f. Current balance %f",
                                                    amountToWithdraw, bankAccount.getBalance());
            assertEquals(expectedMessage, ex.getMessage());
        } catch(Exception ex) {
            fail(String.format("Expected IllegalStateException, but %s was thrown", ex.getClass().getName()));
        }
    }
}
