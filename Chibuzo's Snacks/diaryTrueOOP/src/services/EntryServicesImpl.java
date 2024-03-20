package services;

import data.models.Entry;
import data.repositories.EntryRepository;
import data.repositories.EntryRepositoryImpl;
import exceptions.EmptyEntryListException;
import exceptions.EntryNotFoundException;

import java.util.List;

public class EntryServicesImpl implements EntryServices {
    private final EntryRepository repository = new EntryRepositoryImpl();

    @Override
    public void save(Entry entry) {
        repository.save(entry);
    }

    @Override
    public void deleteEntry(int id) {
        Entry entry = repository.findById(id);
        if (entry == null) throw new EntryNotFoundException("Entry not found");

        repository.delete(id);
    }

    @Override
    public Entry getEntry(int id) {
        Entry entry = repository.findById(id);
        if (entry == null) throw new EntryNotFoundException("Entry not found");

        return entry;
    }

    @Override
    public List<Entry> getEntriesFor(String username) {
        List<Entry> entries = repository.findByName(username.toLowerCase());
        if (entries.isEmpty()) throw new EmptyEntryListException("No entry found");

        return entries;
    }
}
