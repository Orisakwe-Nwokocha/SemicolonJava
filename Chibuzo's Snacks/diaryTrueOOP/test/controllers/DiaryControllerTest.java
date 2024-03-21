package controllers;

import data.repositories.DiaryRepository;
import data.repositories.DiaryRepositoryImpl;
import data.repositories.EntryRepository;
import data.repositories.EntryRepositoryImpl;
import dtos.requests.LoginRequest;
import dtos.requests.RegisterRequest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DiaryControllerTest {
    private DiaryController diaryController;
    private RegisterRequest registerRequest;

    @BeforeEach
    public void startWithThis() {
        diaryController = new DiaryController();

        registerRequest = new RegisterRequest();
        registerRequest.setUsername("Test");
        registerRequest.setPassword("Test");
    }

    @AfterEach
    public void endWithThis() {
        DiaryRepository diaryRepository = new DiaryRepositoryImpl();
        EntryRepository entryRepository = new EntryRepositoryImpl();

        diaryRepository.findAll().clear();
        entryRepository.findAll().clear();
    }

    @Test
    public void testSuccessfulMessageForRegisterUserMethod() {
        assertEquals("registration successful", diaryController.registerUser(registerRequest));
    }

    @Test
    public void registerUserWithNullValues_testErrorMessage() {
        assertEquals("Username and password cannot be null.", diaryController.registerUser(new RegisterRequest()));
    }

    @Test
    public void registerUserWithBlankValues_testErrorMessage() {
        registerRequest.setUsername("");
        registerRequest.setPassword(" ");

        assertEquals("Username and password cannot be blank.", diaryController.registerUser(registerRequest));
        assertEquals("Username and password cannot be blank.", diaryController.registerUser(registerRequest));
    }
    @Test
    public void registerSameUserTwice_testErrorMessage() {
        diaryController.registerUser(registerRequest);
        assertEquals("Username already exists.", diaryController.registerUser(registerRequest));
    }

    @Test
    void loginWithCorrectValues_testSuccessfulMessage() {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername("Test");

    }

    @Test
    void logout() {
    }

    @Test
    void removerUserWith() {
    }

    @Test
    void createEntry() {
    }

    @Test
    void updateEntry() {
    }
}