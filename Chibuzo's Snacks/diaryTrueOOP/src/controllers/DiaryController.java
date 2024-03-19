package controllers;

import data.models.Diary;
import dtos.requests.*;
import exceptions.DiaryAppException;
import services.DiaryServices;
import services.DiaryServicesImpl;
import services.EntryServices;
import services.EntryServicesImpl;

import java.util.List;

public class DiaryController {
    private static final DiaryServices diaryServices = new DiaryServicesImpl();
    private static final EntryServices entryServices = new EntryServicesImpl();

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

    public static String deleteEntryBy(int id, String username) {
        try {
            diaryServices.deleteEntryBy(id, username);
            return "deleted successfully";
        }
        catch (DiaryAppException e) {
            return e.getMessage();
        }
    }

    public static String getEntryBy(int id, String username) {
        try {
            Diary foundDiary = diaryServices.findDiaryBy(username);
            DiaryServicesImpl.checkLockStatusOf(foundDiary);

            return String.valueOf(entryServices.getEntryBy(id));
        }
        catch (DiaryAppException e) {
            return e.getMessage();
        }
    }

    public static List<?> getEntriesFor(String username) {
        try {
            Diary foundDiary = diaryServices.findDiaryBy(username);
            DiaryServicesImpl.checkLockStatusOf(foundDiary);

            return entryServices.getEntriesFor(username);
        }
        catch (DiaryAppException e) {
            return List.of(e.getMessage());
        }
    }

}
