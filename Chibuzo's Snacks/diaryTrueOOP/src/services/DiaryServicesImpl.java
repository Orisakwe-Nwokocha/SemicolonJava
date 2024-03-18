package services;

import data.models.Diary;
import data.models.Entry;
import data.repositories.DiaryRepository;
import data.repositories.DiaryRepositoryImpl;
import dtos.requests.*;
import exceptions.IncorrectPasswordException;
import exceptions.UserNotFoundException;
import exceptions.UsernameExistsException;

public class DiaryServicesImpl implements DiaryServices {
    private final DiaryRepository repository = new DiaryRepositoryImpl();
    private static final EntryServices entryServices = new EntryServicesImpl();

    @Override
    public void register(RegisterRequest request) {
        validate(request);

        Diary diary = new Diary();
        diary.setUsername(request.getUsername().toLowerCase());
        diary.setPassword(request.getPassword());
        repository.save(diary);
    }

    private void validate(RegisterRequest request) {
        validateNull(request);
        validateBlank(request);
        validateDuplicate(request);
    }

    private void validateDuplicate(RegisterRequest request) {
        boolean isDuplicate = repository.findById(request.getUsername()) != null;

        if (isDuplicate) throw new UsernameExistsException("Username already exists.");
    }


    private static void validateBlank(RegisterRequest request) {
        boolean isBlank = request.getUsername().isBlank() || request.getPassword().isBlank();

        if (isBlank) throw new IllegalArgumentException("Username and password cannot be empty.");
    }

    private static void validateNull(RegisterRequest request) {
        boolean isNull = request.getUsername() == null || request.getPassword() == null;

        if (isNull) throw new NullPointerException("Username and password cannot be null.");
    }

    @Override
    public Diary findDiaryBy(String username) {
        Diary foundDiary = repository.findById(username.toLowerCase());
        if (foundDiary == null) throw new UserNotFoundException("User not found.");
        return foundDiary;
    }

    @Override
    public void login(LoginRequest request) {
        Diary foundDiary = findDiaryBy(request.getUsername().toLowerCase());
        if (isPasswordIncorrect(foundDiary, request.getPassword())) throw new IncorrectPasswordException("Password is incorrect.");
        foundDiary.setLock(false);

        repository.save(foundDiary);
    }

    @Override
    public void logout(String username) {
        Diary foundDiary = findDiaryBy(username.toLowerCase());
        foundDiary.setLock(true);

        repository.save(foundDiary);
    }

    private static boolean isPasswordIncorrect(Diary foundDiary, String password) {
        return !foundDiary.getPassword().equals(password);
    }

    @Override
    public void removeUser(RemoveUserRequest request) {
        Diary foundDiary = findDiaryBy(request.getUsername().toLowerCase());

        if (isPasswordIncorrect(foundDiary, request.getPassword())) throw new IncorrectPasswordException("Password is incorrect.");
        repository.delete(foundDiary);
    }

    @Override
    public void createEntryWith(CreateEntryRequest request) {
        Entry entry = new Entry();
        entry.setTitle(request.getTitle());
        entry.setBody(request.getBody());
        entry.setAuthor(request.getAuthor());

        entryServices.add(entry);
    }

    @Override
    public long getNumberOfUsers() {
        return repository.count();
    }
}
