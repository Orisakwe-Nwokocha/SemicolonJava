package services;

import data.models.Diary;
import dtos.requests.*;

public interface DiaryServices {
    void register(RegisterRequest request);
    long getNumberOfUsers();
    Diary findDiaryBy(String username);
    void login(LoginRequest request);
    void logout(String username);
    void removeUser(RemoveUserRequest request);
    void createEntryWith(CreateEntryRequest request);


}
