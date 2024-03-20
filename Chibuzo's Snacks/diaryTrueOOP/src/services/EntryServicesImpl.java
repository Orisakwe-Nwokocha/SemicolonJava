package services;

import data.models.Entry;
import data.repositories.EntryRepository;
import data.repositories.EntryRepositoryImpl;
import exceptions.EmptyEntryException;
import exceptions.EntryNotFoundException;

import java.util.List;

public class EntryServicesImpl implements EntryServices {
    private final EntryRepository repository = new EntryRepositoryImpl();

    @Override
    public void save(Entry entry) {
        repository.save(entry);
    }

    @Override
    public void deleteEntryBy(int id) {
        repository.delete(id);
    }

    @Override
    public Entry getEntryBy(int id) {
        Entry entry = repository.findById(id);
        if (entry == null) throw new EntryNotFoundException("Entry not found");

        return entry;
    }

    @Override
    public List<Entry> getEntriesFor(String username) {
        List<Entry> entries = repository.findByName(username.toLowerCase());
        if (entries.isEmpty()) throw new EmptyEntryException("No entry found");

        return entries;
    }
}
