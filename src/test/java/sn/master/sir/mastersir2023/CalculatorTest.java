package sn.master.sir.mastersir2023;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    Calculator calculator;
    @BeforeEach
    void setUp() {
        calculator = new Calculator();
        calculator.setA(5);
        calculator.setB(5);
    }

    // Add two numbers 5, 5 => 10  => OK
    @Test
    void addTwoNumbersExpectedTheRightValue(){
        int result = calculator.add();
        assertEquals(10, result);

    }

    // add two numbers 5, 5 => 11  => KO
    @Test
    void addTwoNumbersExpectedTheWrongValue(){
        int result = calculator.add();
        assertNotEquals(11, result);
    }

    // Subtract two numbers 5, 5 => 0  => OK
    @Test
    void subtractTwoNumbersReturnTheRightValue(){
        int result = calculator.subtract(5, 5);
        assertEquals(0, result);
    }

    // TODO: Add other test methods for the other methods of the Calculator class

}