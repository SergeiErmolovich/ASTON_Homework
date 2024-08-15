import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FactorialCalculatorTest {

    @Test
    @DisplayName("Факториал нуля равен 1")
    void testFactorialOfZero() {
        assertEquals(1, FactorialCalculator.calculateFactorial(0));
    }

    @Test
    @DisplayName("Факториал единицы равен 1")
    void testFactorialOfOne() {
        assertEquals(1, FactorialCalculator.calculateFactorial(1));
    }

    @Test
    @DisplayName("Факториал пяти равен 120")
    void testFactorialOfFive() {
        assertEquals(120, FactorialCalculator.calculateFactorial(5));
    }

    @Test
    @DisplayName("Факториал десяти равен 3628800")
    void testFactorialOfTen() {
        assertEquals(3628800, FactorialCalculator.calculateFactorial(10));
    }

    @Test
    @DisplayName("Попытка вычислить факториал отрицательного числа вызвает исключение IllegalArgumentException")
    void testFactorialOfNegativeNumber() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            FactorialCalculator.calculateFactorial(-1);
        });
        assertEquals("Number must be non-negative", exception.getMessage());
    }
}