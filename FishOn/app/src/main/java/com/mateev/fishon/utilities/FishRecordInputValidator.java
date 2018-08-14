package com.mateev.fishon.utilities;

import java.util.Calendar;

public class FishRecordInputValidator extends InputValidator {
    private static final int INVALID_NUMBER = 0;
    private static final int MIN_NUMBER_LENGTH = 1;
    private static final int YEAR_LENGTH = 4;
    private static final int MIN_SUPPORTED_YEAR = 1910;

    public boolean isInputYearValid(String year) {

        //checking if the input date length is less than 4 symbols or more
        if ((year.length() < YEAR_LENGTH) || (year.length() > YEAR_LENGTH)) {
            return false;
        }
        //checking if the input consists only digits
        for (int i = 0; i < year.length(); i++) {
            if (Character.isLetter(year.charAt(i))) {
                return false;
            }
        }

        int inputYear = Integer.parseInt(year);
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);

        if (inputYear < MIN_SUPPORTED_YEAR || inputYear > currentYear) {
            return false;
        }

        return true;
    }

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

    public boolean isDecimalNumberValid(String number) {

        if (number.length() < MIN_NUMBER_LENGTH) {
            return false;
        }
        char dot = '.';
        char comma = ',';
        if (number.length() == MIN_NUMBER_LENGTH) {
            if (Character.isDigit(number.charAt(0))) {
                int value = Integer.parseInt(number);
                if (value == INVALID_NUMBER) {
                    return false;
                }
                return true;
            } else {
                return false;
            }

        }

        if ((number.charAt(0) == dot || number.charAt(0) == comma) ||
                (number.charAt(number.length() - 1) == dot || number.charAt(number.length() - 1) == comma)) {
            return false;
        }
        return true;
    }
}
