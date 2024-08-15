import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class FactorialCalculatorTest {

    @Test(description = "Факториал нуля равен 1")
    public void testFactorialOfZero() {
        assertEquals(1, FactorialCalculator.calculateFactorial(0));
    }

    @Test(description = "Факториал единицы равен 1")
    public void testFactorialOfOne() {
        assertEquals(1, FactorialCalculator.calculateFactorial(1));
    }

    @Test(description = "Факториал пяти равен 120")
    public void testFactorialOfFive() {
        assertEquals(120, FactorialCalculator.calculateFactorial(5));
    }

    @Test(description = "Факториал десяти равен 3628800")
    public void testFactorialOfTen() {
        assertEquals(3628800, FactorialCalculator.calculateFactorial(10));
    }

    @Test(description = "Попытка вычислить факториал отрицательного числа вызвает исключение IllegalArgumentException",
            expectedExceptions = IllegalArgumentException.class, expectedExceptionsMessageRegExp = "Number must be non-negative")
    public void testFactorialOfNegativeNumber() {
        FactorialCalculator.calculateFactorial(-1);
    }
}