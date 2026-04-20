package com.example;

public class UserValidator {

    private static final int MIN_AGE = 18;
    private static final int MAX_AGE = 120;
    private static final int MIN_USERNAME_LEN = 3;
    private static final int MAX_USERNAME_LEN = 20;

    public boolean isValidAge(int age) {
        return age >= MIN_AGE && age <= MAX_AGE;
    }

    public boolean isValidUsername(String username) {
        if (username == null) {
            return false;
        }
        int len = username.length();
        return len >= MIN_USERNAME_LEN && len <= MAX_USERNAME_LEN;
    }

    public String normalizeEmail(String email) {
        if (email == null) {
            return null;
        }
        return email.trim().toLowerCase();
    }
}
