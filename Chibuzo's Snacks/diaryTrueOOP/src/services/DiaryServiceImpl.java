package services;

import data.models.Diary;
import data.repositories.DiaryRepository;
import data.repositories.DiaryRepositoryImpl;
import dtos.requests.RegisterRequest;
import services.exceptions.UsernameExistsException;

public class DiaryServiceImpl implements DiaryService {
    private final DiaryRepository repository = new DiaryRepositoryImpl();
    private boolean isLoggedIn;

    @Override
    public void register(RegisterRequest request) {
        validate(request);

        Diary diary = new Diary();
        diary.setUsername(request.getUsername());
        diary.setPassword(request.getPassword());
        repository.save(diary);
    }

    private void validate(RegisterRequest request) {
        validateNull(request);
        validateBlank(request);
        validateDuplicate(request);
    }

    private void validateDuplicate(RegisterRequest request) {
        boolean isDuplicate = findById(request) != null;

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

    private Diary findById(RegisterRequest request) {
        return repository.findById(request.getUsername());
    }

    @Override
    public void login(RegisterRequest request) {
        Diary foundDiary = findById(request.getUsername());

        if (foundDiary != null) loginTo(foundDiary, request);
    }

    private Diary findById(String username) {
        return repository.findById(username);
    }


    private void loginTo(Diary foundDiary, RegisterRequest request) {
        boolean isPasswordCorrect = foundDiary.getPassword().equals(request.getPassword());

        if (isPasswordCorrect) isLoggedIn = true;
    }

    @Override
    public void logout(RegisterRequest request) {
        Diary foundDiary = findById(request.getUsername());

        if (foundDiary != null) logOutOf(foundDiary, request);
    }

    private void logOutOf(Diary foundDiary, RegisterRequest request) {
        boolean isPasswordCorrect = foundDiary.getPassword().equals(request.getPassword());

        if (isPasswordCorrect) isLoggedIn = false;
    }

    @Override
    public boolean isLoggedIn() {
        return isLoggedIn;
    }

    @Override
    public void lock(RegisterRequest request) {
        Diary foundDiary = findById(request.getUsername());

        if (foundDiary != null) foundDiary.lockDiary();
    }

    @Override
    public void unlock(RegisterRequest request) {
        Diary foundDiary = findById(request.getUsername());

        if (foundDiary != null) unlock(foundDiary, request);
    }

    private static void unlock(Diary foundDiary, RegisterRequest request) {
        boolean isPasswordCorrect = foundDiary.getPassword().equals(request.getPassword());

        if (isPasswordCorrect) foundDiary.unlockDiary();
    }

    @Override
    public boolean isLocked(RegisterRequest request) {
        Diary foundDiary = findById(request.getUsername());

        if (foundDiary != null) return foundDiary.isLocked();
        return false;
    }

    @Override
    public void remove(RegisterRequest request) {
        repository.delete(request.getUsername());
    }

    @Override
    public long getNumberOfUsers() {
        return repository.count();
    }
}
