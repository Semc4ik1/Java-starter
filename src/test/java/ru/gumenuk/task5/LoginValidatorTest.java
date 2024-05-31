package ru.gumenuk.task5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LoginValidatorTest {
    @Test
    void testValidateValidLogin() throws WrongLoginException {
        assertTrue(LoginValidator.validate("Valid_login"), "Valid login should pass validation");
    }

    @Test
    void testValidateInvalidLogin() {
        assertThrows(WrongLoginException.class, () -> LoginValidator.validate("valid_login"), "Should throw exception for invalid login");
    }

    @Test
    void testValidateTooLongLogin() {
        assertThrows(WrongLoginException.class, () -> LoginValidator.validate("b".repeat(21)), "Should throw exception for too long login");
    }


}
