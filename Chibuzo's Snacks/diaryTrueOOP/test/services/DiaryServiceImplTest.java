package services;

import dtos.requests.RegisterRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DiaryServiceImplTest {
    private DiaryService diaryService;

    @BeforeEach
    public void initialiseDiaryService() {
        diaryService = new DiaryServiceImpl();
    }

    @Test
    public void testThatDiaryServiceCanRegisterUser_numberOfUsersIs1() {
        RegisterRequest request = new RegisterRequest();
        request.setUsername("username");
        request.setPassword("password");

        diaryService.register(request);
        assertEquals(1L, diaryService.getNumberOfUsers());
    }

    @Test
    public void testRegisterSameUser_UsernameExistsExceptionIsThrown_numberOfUsersIs1() {
        RegisterRequest request = new RegisterRequest();
        request.setUsername("username");
        request.setPassword("password");
        diaryService.register(request);
        assertEquals(1L, diaryService.getNumberOfUsers());

        assertThrows(UsernameExistsException.class, () -> diaryService.register(request));
        assertEquals(1L, diaryService.getNumberOfUsers());
    }

    @Test
    public void testRegisterUserWithNullValue_NullPointerExceptionIsThrown_numberOfUsersIs0() {
        RegisterRequest request = new RegisterRequest();

        assertThrows(NullPointerException.class, () -> diaryService.register(request));
        assertEquals(0L, diaryService.getNumberOfUsers());
    }

    @Test
    public void testRegisterUserWithEmptyString_IllegalArgumentExceptionIsThrown_numberOfUsersIs0() {
        RegisterRequest request = new RegisterRequest();
        request.setUsername(" ");
        request.setPassword(" ");

        assertThrows(IllegalArgumentException.class, () -> diaryService.register(request));
        assertEquals(0L, diaryService.getNumberOfUsers());
    }

    @Test
    public void testThatUserCanLoginIntoAccount() {
        RegisterRequest request = new RegisterRequest();
        request.setUsername("username");
        request.setPassword("password");

        diaryService.register(request);
        assertFalse(diaryService.isLoggedIn());

        diaryService.login(request);
        assertTrue(diaryService.isLoggedIn());
    }

    @Test
    public void testThatUserCanLogoutFromAccount() {
        RegisterRequest request = new RegisterRequest();
        request.setUsername("username");
        request.setPassword("password");

        diaryService.register(request);
        assertFalse(diaryService.isLoggedIn());
        diaryService.login(request);
        assertTrue(diaryService.isLoggedIn());

        diaryService.logout(request);
        assertFalse(diaryService.isLoggedIn());
    }

}