package validate_sa_id;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class ValidateSaId {

    public static boolean isValidSaId(String idNumber) {
        // Check for null or incorrect length
        if (idNumber == null || idNumber.length() != 13) {
            return false;
        }

        // Check all characters are digits
        if (!idNumber.matches("\\d+")) {
            return false;
        }

        // Validate date portion (YYMMDD)
        if (!isValidDate(idNumber.substring(0, 6))) {
            return false;
        }

        // Validate gender digits (positions 6-9, 0000-9999)
        // No specific validation needed as all 4-digit combinations are valid

        // Validate citizenship digit (position 10, must be 0 or 1)
        char citizenshipDigit = idNumber.charAt(10);
        if (citizenshipDigit != '0' && citizenshipDigit != '1') {
            return false;
        }

        // Validate checksum using Luhn algorithm
        return isValidLuhn(idNumber);
    }

    private static boolean isValidDate(String dateStr) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyMMdd");
            LocalDate date = LocalDate.parse(dateStr, formatter);

            // Ensure date is not in the future
            return !date.isAfter(LocalDate.now());
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    private static boolean isValidLuhn(String idNumber) {
        int sum = 0;
        boolean alternate = false;

        for (int i = idNumber.length() - 2; i >= 0; i--) {
            int digit = Character.getNumericValue(idNumber.charAt(i));

            if (alternate) {
                digit *= 2;
                if (digit > 9) {
                    digit = (digit % 10) + 1;
                }
            }

            sum += digit;
            alternate = !alternate;
        }

        int checksum = Character.getNumericValue(idNumber.charAt(idNumber.length() - 1));
        return (10 - (sum % 10)) % 10 == checksum;
    }
}