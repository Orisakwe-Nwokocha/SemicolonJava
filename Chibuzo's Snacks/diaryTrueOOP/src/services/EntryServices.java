package services;

import data.models.Entry;
import dtos.requests.RegisterRequest;

import java.util.List;

public interface EntryServices {
    void add(Entry entry);
    void updateEntry(RegisterRequest request);
    void deleteEntry(RegisterRequest request);
    Entry getEntry(RegisterRequest request);
    List<Entry> getAllEntries();
    List<Entry> getEntriesFor(String username);
}
