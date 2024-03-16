package services;

import dtos.requests.RegisterRequest;
import services.exceptions.UsernameExistsException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DiaryServiceImplTest {
    private DiaryService diaryService;
    private RegisterRequest request;

    @BeforeEach
    public void initialise() {
        diaryService = new DiaryServiceImpl();
        request = new RegisterRequest();

        request.setUsername("username");
        request.setPassword("password");
    }

    @Test
    public void testThatDiaryServiceCanRegisterUser_numberOfUsersIs1() {
        diaryService.register(request);
        assertEquals(1L, diaryService.getNumberOfUsers());
    }

    @Test
    public void testRegisterSameUser_UsernameExistsExceptionIsThrown_numberOfUsersIs1() {
        diaryService.register(request);
        assertEquals(1L, diaryService.getNumberOfUsers());

        assertThrows(UsernameExistsException.class, () -> diaryService.register(request));
        assertEquals(1L, diaryService.getNumberOfUsers());
    }

    @Test
    public void testRegisterUserWithNullValue_NullPointerExceptionIsThrown_numberOfUsersIs0() {
        request = new RegisterRequest();

        assertThrows(NullPointerException.class, () -> diaryService.register(request));
        assertEquals(0L, diaryService.getNumberOfUsers());
    }

    @Test
    public void testRegisterUserWithEmptyString_IllegalArgumentExceptionIsThrown_numberOfUsersIs0() {
        request.setUsername(" ");
        request.setPassword(" ");

        assertThrows(IllegalArgumentException.class, () -> diaryService.register(request));
        assertEquals(0L, diaryService.getNumberOfUsers());
    }

    @Test
    public void testThatUserCanLoginIntoAccount() {
        diaryService.register(request);
        assertFalse(diaryService.isLoggedIn());

        diaryService.login(request);
        assertTrue(diaryService.isLoggedIn());
    }

    @Test
    public void testThatUserCanLogoutFromAccount() {
        diaryService.register(request);
        assertFalse(diaryService.isLoggedIn());

        diaryService.login(request);
        assertTrue(diaryService.isLoggedIn());

        diaryService.logout(request);
        assertFalse(diaryService.isLoggedIn());
    }

    @Test
    public void testThatUserCanLockDiary() {
        diaryService.register(request);
        assertFalse(diaryService.isLocked(request));

        request.setUsername("UserNAME");

        diaryService.lock(request);
        assertTrue(diaryService.isLocked(request));
    }

    @Test
    public void testThatUserCanUnlockDiary() {
        diaryService.register(request);
        assertFalse(diaryService.isLocked(request));
        diaryService.lock(request);
        assertTrue(diaryService.isLocked(request));

        diaryService.unlock(request);
        assertFalse(diaryService.isLocked(request));
    }

    @Test
    public void testThatUserCanDeleteAccount_numberOfUsersIs0() {
        diaryService.register(request);
        assertEquals(1L, diaryService.getNumberOfUsers());

        diaryService.remove(request);
        assertEquals(0L, diaryService.getNumberOfUsers());
    }

}