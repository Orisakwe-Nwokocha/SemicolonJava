package services;

import data.models.Diary;
import data.models.Entry;
import dtos.requests.*;

import java.util.List;

public interface DiaryServices {
    void register(RegisterRequest request);
    long getNumberOfUsers();
    Diary findDiaryBy(String username);
    void login(LoginRequest request);
    void logout(String username);
    void removeUser(RemoveUserRequest request);
    void createEntryWith(CreateEntryRequest request);
    void updateEntryWith(UpdateEntryRequest request);
    void deleteEntryBy(int id, String username);
}
