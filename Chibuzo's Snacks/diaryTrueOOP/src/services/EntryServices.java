package services;

import data.models.Entry;

import java.util.List;

public interface EntryServices {
    void save(Entry entry);
    void deleteEntryBy(int id);
    Entry getEntryBy(int id);
    List<Entry> getEntriesFor(String username);
}
