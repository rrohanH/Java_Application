package com.calculator.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Calculator Service Tests")
class CalculatorServiceTest {

    private final CalculatorService calculatorService = new CalculatorService();

    @Test
    @DisplayName("Test Addition Operation")
    void testAddition() {
        double result = calculatorService.performOperation(5, 3, "+");
        assertEquals(8, result, "5 + 3 should equal 8");
    }

    @Test
    @DisplayName("Test Subtraction Operation")
    void testSubtraction() {
        double result = calculatorService.performOperation(10, 4, "-");
        assertEquals(6, result, "10 - 4 should equal 6");
    }

    @Test
    @DisplayName("Test Multiplication Operation")
    void testMultiplication() {
        double result = calculatorService.performOperation(7, 6, "*");
        assertEquals(42, result, "7 * 6 should equal 42");
    }

    @Test
    @DisplayName("Test Division Operation")
    void testDivision() {
        double result = calculatorService.performOperation(20, 4, "/");
        assertEquals(5, result, "20 / 4 should equal 5");
    }

    @Test
    @DisplayName("Test Division by Zero")
    void testDivisionByZero() {
        assertThrows(IllegalArgumentException.class, () -> {
            calculatorService.performOperation(10, 0, "/");
        }, "Division by zero should throw an exception");
    }

    @Test
    @DisplayName("Test Invalid Operation")
    void testInvalidOperation() {
        assertThrows(IllegalArgumentException.class, () -> {
            calculatorService.performOperation(5, 3, "%");
        }, "Invalid operation should throw an exception");
    }

    @Test
    @DisplayName("Test Square Root Operation")
    void testSquareRoot() {
        double result = calculatorService.performAdvancedOperation(16, "sqrt");
        assertEquals(4, result, "sqrt(16) should equal 4");
    }

    @Test
    @DisplayName("Test Square Operation")
    void testSquare() {
        double result = calculatorService.performAdvancedOperation(5, "square");
        assertEquals(25, result, "5^2 should equal 25");
    }

    @Test
    @DisplayName("Test Reciprocal Operation")
    void testReciprocal() {
        double result = calculatorService.performAdvancedOperation(4, "reciprocal");
        assertEquals(0.25, result, "1/4 should equal 0.25");
    }

    @Test
    @DisplayName("Test Square Root of Negative Number")
    void testNegativeSquareRoot() {
        assertThrows(IllegalArgumentException.class, () -> {
            calculatorService.performAdvancedOperation(-9, "sqrt");
        }, "Square root of negative number should throw an exception");
    }

    @Test
    @DisplayName("Test Reciprocal of Zero")
    void testReciprocalOfZero() {
        assertThrows(IllegalArgumentException.class, () -> {
            calculatorService.performAdvancedOperation(0, "reciprocal");
        }, "Reciprocal of zero should throw an exception");
    }

}
