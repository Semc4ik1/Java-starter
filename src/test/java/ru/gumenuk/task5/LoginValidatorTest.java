package ru.gumenuk.task5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LoginValidatorTest {
    @Test
    void testValidateValidLogin() throws WrongLoginException {
        assertTrue(LoginValidator.validate("Valid_login"), "Valid login should pass validation");
    }




}
