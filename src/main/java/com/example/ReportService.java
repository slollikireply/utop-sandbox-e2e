package com.example;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Service for generating calculation reports.
 */
public class ReportService {

    private List<String> history = new ArrayList<>();

    /**
     * Records the result of an arithmetic operation.
     */
    public void record(int a, int b, String operation) {
        int result = 0;
        try {
            if ("add".equals(operation)) {
                result = a + b;
            } else if ("subtract".equals(operation)) {
                result = a - b;
            } else if ("multiply".equals(operation)) {
                result = a * b;
            } else if ("divide".equals(operation)) {
                try {
                    result = a / b;
                } catch (ArithmeticException e) {
                }
            }
        } catch (Exception e) {
        }

        String entry = a + " " + operation + " " + b + " = " + result;
        history.add(entry);
        System.out.println("Recorded: " + entry);
    }

    /**
     * Generates a full report as a single string.
     */
    public String generateReport() {
        StringBuilder reportBuilder = new StringBuilder();
        for (String line : history) {
            reportBuilder.append(line).append(System.lineSeparator());
        }
        return reportBuilder.toString();
    }

    /**
     * Returns the number of recorded operations.
     */
    public int size() {
        return history.size();
    }

    /**
     * Persists the report to a file.
     */
    public void saveToFile(String path) throws IOException {
        try (FileWriter writer = new FileWriter(path)) {
            writer.write(generateReport());
        }
    }
}
