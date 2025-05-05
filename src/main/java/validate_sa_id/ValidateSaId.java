package validate_sa_id;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class ValidateSaId {

    public static boolean isValidSaId(String idNumber) {
        // Existing validation logic remains the same
        if (idNumber == null || idNumber.length() != 13) {
            return false;
        }

        if (!idNumber.matches("\\d+")) {
            return false;
        }

        if (!isValidDate(idNumber.substring(0, 6))) {
            return false;
        }

        char citizenshipDigit = idNumber.charAt(10);
        if (citizenshipDigit != '0' && citizenshipDigit != '1') {
            return false;
        }

        return isValidLuhn(idNumber);
    }

    public static void validateUserInput() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("South African ID Number Validator");
        System.out.println("---------------------------------");
        System.out.println("Enter ID number (13 digits) or 'exit' to quit:");

        while (true) {
            System.out.print("ID Number: ");
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("exit")) {
                break;
            }

            if (isValidSaId(input)) {
                System.out.println("✅ Valid SA ID Number");
                printIdDetails(input);
            } else {
                System.out.println("❌ Invalid SA ID Number");
            }

            System.out.println(); // Add empty line for separation
        }

        System.out.println("Goodbye!");
        scanner.close();
    }

    private static void printIdDetails(String idNumber) {
        // Extract date parts
        String yy = idNumber.substring(0, 2);
        String mm = idNumber.substring(2, 4);
        String dd = idNumber.substring(4, 6);

        // Determine century (assuming 00-21 is 2000-2021, 22-99 is 1922-1999)
        int year = Integer.parseInt(yy);
        String century = year <= 21 ? "20" + yy : "19" + yy;

        // Gender information
        int genderDigits = Integer.parseInt(idNumber.substring(6, 10));
        String gender = genderDigits < 5000 ? "Female" : "Male";

        // Citizenship
        String citizenship = idNumber.charAt(10) == '0' ? "SA Citizen" : "Permanent Resident";

        System.out.println("\nID Number Details:");
        System.out.println("Date of Birth: " + dd + "-" + mm + "-" + century);
        System.out.println("Gender: " + gender);
        System.out.println("Citizenship: " + citizenship);
    }

    private static boolean isValidDate(String dateStr) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyMMdd");
            LocalDate date = LocalDate.parse(dateStr, formatter);
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