package controllers;

import dtos.requests.*;
import exceptions.DiaryAppException;
import services.DiaryServices;
import services.DiaryServicesImpl;

import java.util.List;

public class DiaryController {
    private final DiaryServices diaryServices = new DiaryServicesImpl();

    public String registerUser(RegisterRequest request) {
        try {
            diaryServices.register(request);
            return "registration successful";
        }
        catch (DiaryAppException e) {
            return e.getMessage();
        }
    }

    public String login(LoginRequest request) {
        try {
            diaryServices.login(request);
            return "login successful";
        }
        catch (DiaryAppException e) {
            return e.getMessage();
        }
    }

    public String logout(String username) {
        try {
            diaryServices.logout(username);
            return "logout successful";
        }
        catch (DiaryAppException e) {
            return e.getMessage();
        }
    }

    public String deregisterUserWith(RemoveUserRequest request) {
        try {
            diaryServices.deregister(request);
            return "removed successfully";
        }
        catch (DiaryAppException e) {
            return e.getMessage();
        }
    }

    public String createEntry(CreateEntryRequest createEntryRequest) {
        try {
            diaryServices.createEntryWith(createEntryRequest);
            return "created successfully";
        }
        catch (DiaryAppException e) {
            return e.getMessage();
        }
    }

    public String updateEntry(UpdateEntryRequest request) {
        try {
            diaryServices.updateEntryWith(request);
            return "updated successfully";
        }
        catch (DiaryAppException e) {
            return e.getMessage();
        }
    }

    public String deleteEntryBy(int id, String username) {
        try {
            diaryServices.deleteEntry(id, username);
            return "deleted successfully";
        }
        catch (DiaryAppException e) {
            return e.getMessage();
        }
    }

    public String getEntryBy(int id, String username) {
        try {
            return String.valueOf(diaryServices.getEntry(id, username));
        }
        catch (DiaryAppException e) {
            return e.getMessage();
        }
    }

    public List<?> getEntriesFor(String username) {
        try {
            return diaryServices.getEntriesFor(username);
        }
        catch (DiaryAppException e) {
            return List.of(e.getMessage());
        }
    }
}
