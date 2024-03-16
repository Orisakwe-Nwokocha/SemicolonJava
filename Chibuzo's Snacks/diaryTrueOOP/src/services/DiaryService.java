package services;

import dtos.requests.RegisterRequest;

public interface DiaryService {
    void register(RegisterRequest request);
    void login(RegisterRequest request);
    void logout(RegisterRequest request);
    boolean isLoggedIn();
    void lock(RegisterRequest request);
    void unlock(RegisterRequest request);
    boolean isLocked(RegisterRequest request);
    void remove(RegisterRequest request);
    long getNumberOfUsers();
}
