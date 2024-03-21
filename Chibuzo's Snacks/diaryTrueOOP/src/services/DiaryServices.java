package services;

import data.models.Diary;
import data.models.Entry;
import dtos.requests.*;

import java.util.List;

public interface DiaryServices {
    void register(RegisterRequest registerRequest);
    Diary findDiaryBy(String username);
    void login(LoginRequest loginRequest);
    void logout(String username);
    void deregister(RemoveUserRequest removeUserRequest);
    void createEntryWith(CreateEntryRequest createEntryRequest);
    void updateEntryWith(UpdateEntryRequest updateEntryRequest);
    void deleteEntry(int id, String username);
    Entry getEntry(int id, String username);
    List<Entry> getEntriesFor(String username);
}
