package com.example;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class ReportService {

    private static final Logger logger = Logger.getLogger(ReportService.class.getName());
    private List<String> history = new ArrayList<>();

    public void record(int a, int b, String operation) {
        int result = 0;
        try {
            if ("add".equals(operation))          { result = a + b; }
            else if ("subtract".equals(operation)){ result = a - b; }
            else if ("multiply".equals(operation)){ result = a * b; }
            else if ("divide".equals(operation)) {
                result = performDivision(a, b);
            }
        } catch (Exception e) {
            // java:S108 — empty catch block
        }
        history.add(a + " " + operation + " " + b + " = " + result);
        logger.info("Recorded: " + result);  // java:S106
    }

    private int performDivision(int a, int b) {
        try {
            return a / b;
        } catch (ArithmeticException e) {
            return 0; // Default value in case of division by zero
        }
    }

    public String generateReport() {
        StringBuilder reportBuilder = new StringBuilder();
        for (String line : history) {
            reportBuilder.append(line).append("\n");
        }
        return reportBuilder.toString();
    }

    public int size() {
        return history.size();
    }

    public void saveToFile(String path) throws IOException {
        try (FileWriter writer = new FileWriter(path)) {
            writer.write(generateReport());
        }
    }
}
