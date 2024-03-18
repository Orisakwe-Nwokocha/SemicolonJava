package services;

import dtos.requests.*;
import exceptions.UsernameExistsException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DiaryServicesImplTest {
    private DiaryServices diaryServices;
    private RegisterRequest registerRequest;
    private LoginRequest loginRequest;
    private CreateEntryRequest createEntryRequest;
    private EntryServices entryServices = new EntryServicesImpl();

    @BeforeEach
    public void initialise() {
        diaryServices = new DiaryServicesImpl();
        registerRequest = new RegisterRequest();

        registerRequest.setUsername("username");
        registerRequest.setPassword("password");

        loginRequest = new LoginRequest();
        loginRequest.setUsername("username");
        loginRequest.setPassword("password");

        createEntryRequest = new CreateEntryRequest();
        createEntryRequest.setTitle("title");
        createEntryRequest.setBody("body");
        createEntryRequest.setAuthor("username");
    }

    @Test
    public void testThatDiaryServiceCanRegisterUser_numberOfUsersIs1() {
        diaryServices.register(registerRequest);
        assertEquals(1L, diaryServices.getNumberOfUsers());
    }

    @Test
    public void testRegisterSameUser_UsernameExistsExceptionIsThrown_numberOfUsersIs1() {
        diaryServices.register(registerRequest);
        assertEquals(1L, diaryServices.getNumberOfUsers());

        assertThrows(UsernameExistsException.class, () -> diaryServices.register(registerRequest));
        assertEquals(1L, diaryServices.getNumberOfUsers());
    }

    @Test
    public void testRegisterUserWithNullValue_NullPointerExceptionIsThrown_numberOfUsersIs0() {
        registerRequest = new RegisterRequest();

        assertThrows(NullPointerException.class, () -> diaryServices.register(registerRequest));
        assertEquals(0L, diaryServices.getNumberOfUsers());
    }

    @Test
    public void testRegisterUserWithEmptyString_IllegalArgumentExceptionIsThrown_numberOfUsersIs0() {
        registerRequest.setUsername(" ");
        registerRequest.setPassword(" ");

        assertThrows(IllegalArgumentException.class, () -> diaryServices.register(registerRequest));
        assertEquals(0L, diaryServices.getNumberOfUsers());
    }

    @Test
    public void testThatUserCanLogoutFromAccount() {
        diaryServices.register(registerRequest);

        diaryServices.logout("username");
        assertTrue(diaryServices.findDiaryBy("username").isLocked());
    }

    @Test
    public void testThatUserCanLoginIntoAccount() {
        diaryServices.register(registerRequest);
        assertTrue(diaryServices.findDiaryBy("username").isLocked());

        diaryServices.login(loginRequest);
        assertFalse(diaryServices.findDiaryBy("username").isLocked());
    }

    @Test
    public void testThatUserCanDeleteAccount_numberOfUsersIs0() {
        diaryServices.register(registerRequest);
        assertEquals(1L, diaryServices.getNumberOfUsers());

        RemoveUserRequest request = new RemoveUserRequest();
        request.setUsername("username");
        request.setPassword("password");
        diaryServices.removeUser(request);
        assertEquals(0L, diaryServices.getNumberOfUsers());
    }

    @Test
    public void userLogsIntoDiaryServiceWithIncorrectPassword_IllegalArgumentExceptionIsThrownTest() {
        diaryServices.register(registerRequest);

        loginRequest.setPassword("incorrectPassword");
        assertThrows(IllegalArgumentException.class, () -> diaryServices.login(loginRequest));
    }
    @Test
    public void userDeletesDiaryWithIncorrectPassword_IllegalArgumentExceptionIsThrownTest() {
        diaryServices.register(registerRequest);

        RemoveUserRequest removeUserRequest = new RemoveUserRequest();
        removeUserRequest.setUsername("username");
        removeUserRequest.setPassword("incorrectPassword");

        assertThrows(IllegalArgumentException.class, () -> diaryServices.removeUser(removeUserRequest));
    }

    @Test
    public void userAddsNewEntryToDiaryService_numberOfEntriesIs1Test() {
        diaryServices.register(registerRequest);
        assertEquals(1L, diaryServices.getNumberOfUsers());

        diaryServices.createEntryWith(createEntryRequest);
        assertEquals(1, entryServices.getEntriesFor("username").size());
    }
}