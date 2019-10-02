package nathan.apprenticeship.calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

    public static CalculatorImpl calculator;

    @BeforeAll
    static void setup(){
        calculator = new CalculatorImpl();
    }

    @Test
    @DisplayName("Addition Test")
    void addition(){
        assertEquals(2, calculator.add(1, 1));
    }

    @Test
    @DisplayName("Subtraction Test")
    void subtraction(){
        assertEquals(1, calculator.subtract(5, 4));
    }

    @Test
    @DisplayName("Multiplication Test")
    void multiplication(){
        assertEquals(100, calculator.multiply(10, 10));
    }

    @Test
    @DisplayName("Division Test")
    void division(){
        assertEquals(1, calculator.divide(3, 2));
    }
}
