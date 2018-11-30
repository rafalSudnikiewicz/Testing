package pl.sda;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import pl.sda.Calculator;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class CalculatorTests {

    private final Calculator calculator;
    private final int firstNumber;
    private final int secondNumber;
    private final int expectedSumResult;

    public CalculatorTests(int firstNumber, int secondNumber, int expectedSumResult) {
        calculator = new Calculator();
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
        this.expectedSumResult = expectedSumResult;
    }

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {2, 3, 5}, {4, 5, 9}
        });
    }

    @Test
    public void addingTwoNumbersShouldReturnExpectedResult() {
        // When
        int result = calculator.add(firstNumber, secondNumber);

        // Then
        assertEquals(expectedSumResult, result);
    }
}


