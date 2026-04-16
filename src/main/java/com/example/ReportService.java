package com.example;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReportService {

    private List<String> history = new ArrayList<>();

    public void record(int a, int b, String operation) {
        int result = 0;
        try {
            if ("add".equals(operation))          { result = a + b; }
            else if ("subtract".equals(operation)){ result = a - b; }
            else if ("multiply".equals(operation)){ result = a * b; }
            else if ("divide".equals(operation)) {
                try {
                    result = a / b;
                } catch (ArithmeticException e) {
                    // java:S108 — empty catch block
                }
            }
        } catch (Exception e) {
            // java:S108 — empty catch block
        }
        history.add(a + " " + operation + " " + b + " = " + result);
        System.out.println("Recorded: " + result);  // java:S106
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
