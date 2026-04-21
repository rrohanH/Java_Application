package com.calculator.controller;

import com.calculator.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * REST Controller for calculator operations
 */
@RestController
@RequestMapping("/api/calculator")
@CrossOrigin(origins = "*")
public class CalculatorController {

    @Autowired
    private CalculatorService calculatorService;

    /**
     * Performs basic arithmetic operations
     * @param num1 First number
     * @param num2 Second number
     * @param operation Operation: +, -, *, /
     * @return Result of the operation
     */
    @PostMapping("/calculate")
    public ResponseEntity<Map<String, Object>> calculate(
            @RequestParam double num1,
            @RequestParam double num2,
            @RequestParam String operation) {
        
        Map<String, Object> response = new HashMap<>();
        
        try {
            double result = calculatorService.performOperation(num1, num2, operation);
            response.put("success", true);
            response.put("num1", num1);
            response.put("num2", num2);
            response.put("operation", operation);
            response.put("result", result);
        } catch (IllegalArgumentException e) {
            response.put("success", false);
            response.put("error", e.getMessage());
        }
        
        return ResponseEntity.ok(response);
    }

    /**
     * Performs advanced operations
     * @param number The input number
     * @param operation Operation: sqrt, square, reciprocal
     * @return Result of the operation
     */
    @PostMapping("/advanced")
    public ResponseEntity<Map<String, Object>> advanced(
            @RequestParam double number,
            @RequestParam String operation) {
        
        Map<String, Object> response = new HashMap<>();
        
        try {
            double result = calculatorService.performAdvancedOperation(number, operation);
            response.put("success", true);
            response.put("number", number);
            response.put("operation", operation);
            response.put("result", result);
        } catch (IllegalArgumentException e) {
            response.put("success", false);
            response.put("error", e.getMessage());
        }
        
        return ResponseEntity.ok(response);
    }

    /**
     * Health check endpoint
     */
    @GetMapping("/health")
    public ResponseEntity<Map<String, String>> health() {
        Map<String, String> response = new HashMap<>();
        response.put("status", "OK");
        response.put("message", "Calculator API is running");
        return ResponseEntity.ok(response);
    }

}
