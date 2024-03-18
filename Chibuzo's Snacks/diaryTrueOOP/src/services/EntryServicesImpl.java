package services;

import data.models.Entry;
import data.repositories.EntryRepository;
import data.repositories.EntryRepositoryImpl;
import dtos.requests.RegisterRequest;

import java.util.ArrayList;
import java.util.List;

public class EntryServicesImpl implements EntryServices {
    private static final EntryRepository repository = new EntryRepositoryImpl();

    @Override
    public void add(Entry entry) {
        repository.save(entry);
    }

    @Override
    public void updateEntry(RegisterRequest request) {

    }

    @Override
    public void deleteEntry(RegisterRequest request) {

    }

    @Override
    public Entry getEntry(RegisterRequest request) {
        return null;
    }

    @Override
    public List<Entry> getAllEntries() {
        return null;
    }

    @Override
    public List<Entry> getEntriesFor(String username) {
        List<Entry> entries = new ArrayList<>();
        for (Entry entry : repository.findAll()) if (entry.getAuthor().equals(username)) entries.add(entry);

        if (entries.isEmpty()) throw new EmptyEntryException("No entry found");
        return entries;
    }
}
