package com.mateev.fishon.utilities;

public class InputValidator {
    static final int MIN_STRING_LENGTH = 3;

    public boolean isStringValid(String input) {

        if ((input.length() < MIN_STRING_LENGTH)) {
            return false;
        }
        for (int i = 0; i < input.length(); i++) {
            if (Character.isDigit(input.charAt(i))) {
                return false;
            }
        }

        return true;

    }
}
