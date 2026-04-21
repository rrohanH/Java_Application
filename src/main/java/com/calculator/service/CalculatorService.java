package com.calculator.service;

import org.springframework.stereotype.Service;

/**
 * Service class for calculator operations
 */
@Service
public class CalculatorService {

    /**
     * Performs basic arithmetic operations
     * @param num1 First number
     * @param num2 Second number
     * @param operation Operation to perform: +, -, *, /
     * @return Result of the operation
     * @throws IllegalArgumentException if operation is invalid or division by zero
     */
    public double performOperation(double num1, double num2, String operation) {
        switch (operation) {
            case "+":
                return add(num1, num2);
            case "-":
                return subtract(num1, num2);
            case "*":
                return multiply(num1, num2);
            case "/":
                return divide(num1, num2);
            default:
                throw new IllegalArgumentException("Invalid operation: " + operation + ". Supported operations: +, -, *, /");
        }
    }

    /**
     * Performs advanced mathematical operations
     * @param number The input number
     * @param operation Operation to perform: sqrt, square, reciprocal
     * @return Result of the operation
     * @throws IllegalArgumentException if operation is invalid
     */
    public double performAdvancedOperation(double number, String operation) {
        switch (operation) {
            case "sqrt":
                return squareRoot(number);
            case "square":
                return square(number);
            case "reciprocal":
                return reciprocal(number);
            default:
                throw new IllegalArgumentException("Invalid operation: " + operation + ". Supported operations: sqrt, square, reciprocal");
        }
    }

    private double add(double num1, double num2) {
        return num1 + num2;
    }

    private double subtract(double num1, double num2) {
        return num1 - num2;
    }

    private double multiply(double num1, double num2) {
        return num1 * num2;
    }

    private double divide(double num1, double num2) {
        if (num2 == 0) {
            throw new IllegalArgumentException("Division by zero is not allowed");
        }
        return num1 / num2;
    }

    private double squareRoot(double num) {
        if (num < 0) {
            throw new IllegalArgumentException("Cannot calculate square root of a negative number");
        }
        return Math.sqrt(num);
    }

    private double square(double num) {
        return num * num;
    }

    private double reciprocal(double num) {
        if (num == 0) {
            throw new IllegalArgumentException("Cannot calculate reciprocal of zero");
        }
        return 1 / num;
    }

}
