package ru.gumenuk.task5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LoginValidatorTest {
    @Test
    void validate_shouldReturnTrue_loginIsValid() throws WrongLoginException {
        assertTrue(LoginValidator.validate("Valid_login"));
    }

    @Test
    void validate_shouldThrowWrongLoginExceptionWithMessage1a_loginIsNotValid() {
        WrongLoginException e = assertThrows(WrongLoginException.class, () ->
                LoginValidator.validate("Малдкилуьб"));
        assertEquals("1a", e.getMessage());
    }

    @Test
    void isValid_shouldReturnFalse_loginRegexpMismatch() {
        assertFalse(LoginValidator.isValid("Привет"));
    }

    @Test
    void isValid_shouldReturnTrue_correctLogin() {
        assertTrue(LoginValidator.isValid("correctLogin"));
    }


    @Test
    void validate_shouldThrowWrongLoginExceptionWithMessage1b_tooLongLoginLength() {
        WrongLoginException e = assertThrows(WrongLoginException.class, () ->
                LoginValidator.validate("123451234512345123451"));
        assertEquals("1b", e.getMessage());
    }
}
