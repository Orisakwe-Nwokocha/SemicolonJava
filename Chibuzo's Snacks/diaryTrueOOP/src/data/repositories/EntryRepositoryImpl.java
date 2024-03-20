package data.repositories;

import data.models.Entry;

import java.util.ArrayList;
import java.util.List;

public class EntryRepositoryImpl implements EntryRepository {
    private static final List<Entry> entries = new ArrayList<>();
    private int lastEntryId;

    @Override
    public Entry save(Entry entry) {
        if (isNew(entry)) addIdTo(entry);
        else update(entry);

        entries.add(entry);

        return entry;
    }

    private void update(Entry entry) {
        Entry oldEntry = findById(entry.getId());
        entry.setCreationDate(oldEntry.getCreationDate());

        entries.remove(oldEntry);
    }

    private void addIdTo(Entry entry) {
        entry.setId(generateId());
    }

    private int generateId() {
        return ++lastEntryId;
    }

    private boolean isNew(Entry entry) {
        return entry.getId() == 0;
    }

    @Override
    public List<Entry> findAll() {
        return entries;
    }

    @Override
    public Entry findById(int id) {
        for (Entry entry : entries) if (entry.getId() == id) return entry;

        return null;
    }

    @Override
    public long count() {
        return entries.size();
    }

    @Override
    public void delete(int id) {
        Entry foundEntry = findById(id);

        entries.remove(foundEntry);
    }

    @Override
    public void delete(Entry entry) {
        entries.remove(entry);
    }

    @Override
    public List<Entry> findByName(String username) {
        List<Entry> foundEntries = new ArrayList<>();
        for (Entry entry : entries) if (entry.getAuthor().equalsIgnoreCase(username)) foundEntries.add(entry);

        return foundEntries;
    }
}
