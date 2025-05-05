package validate_sa_id;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ValidateSaIdTest {

    @Test
    public void testValidIdNumbers() {
        assertTrue(ValidateSaId.isValidSaId("2001014800086"));
        assertTrue(ValidateSaId.isValidSaId("2909035800085"));
    }

    @Test
    public void testNullInput() {
        assertFalse(ValidateSaId.isValidSaId(null));
    }

    @Test
    public void testInvalidLength() {
        assertFalse(ValidateSaId.isValidSaId("")); // Empty string
        assertFalse(ValidateSaId.isValidSaId("123")); // Too short
        assertFalse(ValidateSaId.isValidSaId("2001014800086123")); // Too long
    }

    @Test
    public void testNonNumericCharacters() {
        assertFalse(ValidateSaId.isValidSaId("200101480008A")); // Contains letter
        assertFalse(ValidateSaId.isValidSaId("20010148000 6")); // Contains space
        assertFalse(ValidateSaId.isValidSaId("20010148000.6")); // Contains period
    }

    @Test
    public void testInvalidDates() {
        // Invalid month
        assertFalse(ValidateSaId.isValidSaId("2013014800086"));
        // Invalid day
        assertFalse(ValidateSaId.isValidSaId("2001324800086"));
        // February 30th
        assertFalse(ValidateSaId.isValidSaId("2002304800086"));
        // Future date
        assertFalse(ValidateSaId.isValidSaId("5012014800086"));
    }

    @Test
    public void testInvalidCitizenshipDigit() {
        assertFalse(ValidateSaId.isValidSaId("2001014800286")); // Citizenship digit 2
        assertFalse(ValidateSaId.isValidSaId("2001014800386")); // Citizenship digit 3
        assertFalse(ValidateSaId.isValidSaId("2001014800986")); // Citizenship digit 9
    }

    @Test
    public void testInvalidChecksum() {
        // Valid ID but with last digit changed
        assertFalse(ValidateSaId.isValidSaId("2001014800087"));
        assertFalse(ValidateSaId.isValidSaId("2909035800086"));
    }

    @Test
    public void testGenderDigits() {
        // Female (0000-4999)
        assertTrue(ValidateSaId.isValidSaId("2001010000086"));
        assertTrue(ValidateSaId.isValidSaId("2001014999086"));
        // Male (5000-9999)
        assertTrue(ValidateSaId.isValidSaId("2001015000085"));
        assertTrue(ValidateSaId.isValidSaId("2001019999083"));
    }
}