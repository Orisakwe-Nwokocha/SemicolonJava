package data.repositories;

import data.models.Diary;
import data.models.Entry;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EntryRepositoryImplTest {
    private EntryRepository repository;

    @BeforeEach
    public void startWithThis() {
        repository = new EntryRepositoryImpl();
    }

    @Test
    public void saveEntry_numberOfEntriesIs1Test() {
        assertEquals(0L, repository.count());

        Entry entry = new Entry("title", "body", "author");
        repository.save(entry);

        assertEquals(1L, repository.count());
    }

    @Test
    public void updateSavedEntry_numberOfEntries1Test() {
        Entry entry = new Entry("title", "body", "author");
        repository.save(entry);
        assertEquals(1L, repository.count());

        Entry updatedEntry = new Entry();
        updatedEntry.setId(1);
        updatedEntry.setTitle("newTitle");
        updatedEntry.setBody("newBody");
        repository.save(updatedEntry);

        assertEquals(1L, repository.count());
    }

    @Test
    public void save2Entries_deleteSecondSavedEntryById_numberOfEntries1Test() {
        Entry entry1 = new Entry("title", "body", "author");
        repository.save(entry1);
        Entry entry2 = new Entry("title", "body", "author2");
        repository.save(entry2);
        assertEquals(2L, repository.findAll().size());


        repository.delete(2);
        assertEquals(1L, repository.findAll().size());
    }

    @Test
    public void save2Entries_deleteFirstSavedEntryByEntry_numberOfEntries1Test() {
        Entry entry1 = new Entry("title", "body", "author");
        repository.save(entry1);
        Entry entry2 = new Entry("title", "body", "author2");
        repository.save(entry2);
        assertEquals(2L, repository.findAll().size());


        repository.delete(entry1);
        assertEquals(1L, repository.findAll().size());
    }
}