package ru.gumenuk.task5;

import org.junit.jupiter.api.Test;

import java.lang.invoke.WrongMethodTypeException;

import static org.junit.jupiter.api.Assertions.*;

class LoginValidatorTest {
    @Test
    void validate_shouldReturnTrue_loginIsValid() throws WrongLoginException {
        assertTrue(LoginValidator.validate("Valid_login"), "assertTrue(condition");

    }
    @Test
    void isValid_ShouldNoPositive_isValid() throws WrongMethodTypeException {

        assertFalse(LoginValidator.isValid("Привет"));
    }
    @Test
    void validate_shouldBeLess_LoginLength() throws IllegalArgumentException, WrongLoginException {

        assertFalse(LoginValidator.validate("LoginTooLongVeryVeryVery"));
    }






}
