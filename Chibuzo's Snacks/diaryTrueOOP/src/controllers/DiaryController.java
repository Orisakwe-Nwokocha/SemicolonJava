package controllers;

import dtos.requests.*;
import exceptions.DiaryAppException;
import services.DiaryServices;
import services.DiaryServicesImpl;

public class DiaryController {
    private static final DiaryServices diaryServices = new DiaryServicesImpl();

    public static String registerUser(RegisterRequest request) {
        try {
            diaryServices.register(request);
            return "registration successful";
        }
        catch (DiaryAppException e) {
            return e.getMessage();
        }
    }

    public static String login(LoginRequest request) {
        try {
            diaryServices.login(request);
            return "login successful";
        }
        catch (DiaryAppException e) {
            return e.getMessage();
        }
    }

    public static String logout(String username) {
        try {
            diaryServices.logout(username);
            return "logout successful";
        }
        catch (DiaryAppException e) {
            return e.getMessage();
        }
    }

    public static String removerUserWith(RemoveUserRequest request) {
        try {
            diaryServices.removeUser(request);
            return "removed successfully";
        }
        catch (DiaryAppException e) {
            return e.getMessage();
        }
    }

    public static String createEntry(CreateEntryRequest request) {
        try {
            diaryServices.createEntryWith(request);
            return "created successfully";
        }
        catch (DiaryAppException e) {
            return e.getMessage();
        }
    }

    public static String updateEntry(UpdateEntryRequest request) {
        try {
            diaryServices.updateEntryWith(request);
            return "updated successfully";
        }
        catch (DiaryAppException e) {
            return e.getMessage();
        }
    }
}
