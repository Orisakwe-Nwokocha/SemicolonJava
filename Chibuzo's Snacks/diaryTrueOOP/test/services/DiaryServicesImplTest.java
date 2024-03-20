package services;

import data.repositories.DiaryRepositoryImpl;
import data.repositories.EntryRepository;
import data.repositories.EntryRepositoryImpl;
import dtos.requests.*;
import exceptions.IncorrectPasswordException;
import exceptions.InvalidArgumentException;
import exceptions.UsernameExistsException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DiaryServicesImplTest {
    private DiaryServices diaryServices;
    private RegisterRequest registerRequest;
    private LoginRequest loginRequest;
    private CreateEntryRequest createEntryRequest;
    private final EntryServices entryServices = new EntryServicesImpl();
    private final DiaryRepositoryImpl diaryRepository = new DiaryRepositoryImpl();

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

    @AfterEach
    public void cleanup() {
        EntryRepository entryRepository  = new EntryRepositoryImpl();

        diaryRepository.findAll().clear();
        entryRepository.findAll().clear();
    }

    @Test
    public void testThatDiaryServiceCanRegisterUser_numberOfUsersIs1() {
        assertEquals(0L, diaryRepository.count());

        diaryServices.register(registerRequest);
        assertEquals(1L, diaryRepository.count());
    }

    @Test
    public void testRegisterSameUser_UsernameExistsExceptionIsThrown_numberOfUsersIs1() {
        diaryServices.register(registerRequest);
        assertEquals(1L, diaryRepository.count());

        assertThrows(UsernameExistsException.class, () -> diaryServices.register(registerRequest));
        assertEquals(1L, diaryRepository.count());
    }

    @Test
    public void testRegisterUserWithNullValue_InvalidArgumentExceptionIsThrown_numberOfUsersIs0() {
        assertEquals(0L, diaryRepository.count());
        registerRequest = new RegisterRequest();

        assertThrows(InvalidArgumentException.class, () -> diaryServices.register(registerRequest));
        assertEquals(0L, diaryRepository.count());
    }

    @Test
    public void testRegisterUserWithEmptyString_InvalidArgumentExceptionIsThrown_numberOfUsersIs0() {
        assertEquals(0L, diaryRepository.count());
        registerRequest.setUsername(" ");
        registerRequest.setPassword(" ");

        assertThrows(InvalidArgumentException.class, () -> diaryServices.register(registerRequest));
        assertEquals(0L, diaryRepository.count());
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
        assertEquals(1L, diaryRepository.count());

        RemoveUserRequest request = new RemoveUserRequest();
        request.setUsername("username");
        request.setPassword("password");
        diaryServices.login(loginRequest);
        diaryServices.removeUser(request);
        assertEquals(0L, diaryRepository.count());
    }

    @Test
    public void userLogsIntoDiaryServiceWithIncorrectPassword_IncorrectPasswordExceptionIsThrownTest() {
        diaryServices.register(registerRequest);

        loginRequest.setPassword("incorrectPassword");
        assertThrows(IncorrectPasswordException.class, () -> diaryServices.login(loginRequest));
    }
    @Test
    public void userDeletesDiaryWithIncorrectPassword_IncorrectPasswordExceptionIsThrownTest() {
        diaryServices.register(registerRequest);

        RemoveUserRequest removeUserRequest = new RemoveUserRequest();
        removeUserRequest.setUsername("username");
        removeUserRequest.setPassword("incorrectPassword");
        diaryServices.login(loginRequest);

        assertThrows(IncorrectPasswordException.class, () -> diaryServices.removeUser(removeUserRequest));
    }

    @Test
    public void userAddsNewEntry_numberOfEntriesIs1Test() {
        diaryServices.register(registerRequest);

        diaryServices.login(loginRequest);
        diaryServices.createEntryWith(createEntryRequest);
        assertEquals(1, entryServices.getEntriesFor("username").size());
    }

    @Test
    public void userUpdatesSavedEntry_numberOfEntriesIs1Test() {
        diaryServices.register(registerRequest);

        diaryServices.login(loginRequest);
        diaryServices.createEntryWith(createEntryRequest);
        assertEquals("title", entryServices.getEntriesFor("username").getFirst().getTitle());
        assertEquals(1, entryServices.getEntriesFor("username").size());

        UpdateEntryRequest updateEntryRequest = new UpdateEntryRequest();
        updateEntryRequest.setTitle("newTitle");
        updateEntryRequest.setBody("newBody");
        updateEntryRequest.setAuthor("username");
        updateEntryRequest.setId(1);

        diaryServices.updateEntryWith(updateEntryRequest);
        assertEquals("newTitle", entryServices.getEntriesFor("username").getFirst().getTitle());
        assertEquals(1, entryServices.getEntriesFor("username").size());
    }

    @Test
    public void given2SavedEntries_whenUserDeletes1SavedEntry_thenNumberOfEntriesIs1Test() {
        diaryServices.register(registerRequest);

        diaryServices.login(loginRequest);
        diaryServices.createEntryWith(createEntryRequest);
        diaryServices.createEntryWith(createEntryRequest);
        assertEquals(2, entryServices.getEntriesFor("username").size());

        entryServices.deleteEntry(1);
        assertEquals(1, entryServices.getEntriesFor("username").size());
    }
}