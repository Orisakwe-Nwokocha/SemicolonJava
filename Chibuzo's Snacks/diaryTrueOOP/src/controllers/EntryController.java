package controllers;

import data.models.Diary;
import exceptions.DiaryAppException;
import services.DiaryServices;
import services.DiaryServicesImpl;
import services.EntryServices;
import services.EntryServicesImpl;

import java.util.List;

public class EntryController {
    private static final EntryServices entryServices =  new EntryServicesImpl();
    private static final DiaryServices diaryServices = new DiaryServicesImpl();

    public static String deleteEntryBy(int id, String username) {
        try {
            Diary foundDiary = diaryServices.findDiaryBy(username);
            DiaryServicesImpl.checkLockStatusOf(foundDiary);

            entryServices.deleteEntry(id);
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

            return String.valueOf(entryServices.getEntry(id));
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
