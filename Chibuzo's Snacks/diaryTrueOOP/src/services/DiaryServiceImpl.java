package services;

import data.models.Diary;
import data.repositories.DiaryRepository;
import data.repositories.DiaryRepositoryImpl;
import dtos.requests.RegisterRequest;

public class DiaryServiceImpl implements DiaryService {
    private final DiaryRepository repository = new DiaryRepositoryImpl();
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
        if (repository.findById(request.getUsername()) != null) throw new UsernameExistsException("Username already exists.");
    }

    private static void validateBlank(RegisterRequest request) {
        if (request.getUsername().isBlank() || request.getPassword().isBlank()) throw new IllegalArgumentException("Username and password cannot be empty.");
    }

    private static void validateNull(RegisterRequest request) {
        if (request.getUsername() == null || request.getPassword() == null) throw new NullPointerException("Username and password cannot be null.");
    }

    @Override
    public void login(RegisterRequest request) {

    }

    @Override
    public void logout(RegisterRequest request) {

    }

    @Override
    public void lock(RegisterRequest request) {

    }

    @Override
    public void unlock(RegisterRequest request) {

    }

    @Override
    public void removeUser(RegisterRequest request) {

    }

    @Override
    public long getNumberOfUsers() {
        return repository.count();
    }
}
