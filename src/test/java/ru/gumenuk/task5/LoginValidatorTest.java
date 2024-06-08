package ru.gumenuk.task5;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LoginValidatorTest {
    @Test
    void validate_shouldReturnTrue_loginIsValid() throws WrongLoginException {
        assertTrue(LoginValidator.validate("Valid_login"));

    }
    @Test
    void validate_shouldReturnFalse_loginIsValidMismatch() throws WrongLoginException {
        assertFalse(LoginValidator.validate("Valid_login 3544 "));
        WrongLoginException e = assertThrows(WrongLoginException.class, () ->
                LoginValidator.isValid("Малдкилуьб")); assertEquals("1a", e.getMessage());
    }
    @Test
    void isValid_shouldReturnFalse_loginRegexpMismatch()  {

        assertFalse(LoginValidator.isValid("Привет"));
        WrongLoginException e = assertThrows(WrongLoginException.class, () ->
                LoginValidator.isValid("Малдкилуьб")); assertEquals("1a", e.getMessage());
    }
    @Test
    void validate_shouldBeLess_LoginLength() throws  WrongLoginException {

        assertFalse(LoginValidator.validate("LoginTooLongVeryVeryVery"));
        WrongLoginException e = assertThrows(WrongLoginException.class, () ->
                LoginValidator.validate("Fgegrgemgegemggmem")); assertEquals("1b", e.getMessage());
    }






}
