package data.repositories;

import data.models.Entry;

import java.util.List;

public interface EntryRepository {
    Entry save(Entry entry);
    List<Entry> findAll();
    Entry findById(int id);
    long count();
    void delete(int id);
    void delete(Entry entry);
    List<Entry> findByName(String username);
}
