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

        Entry entry = new Entry();
        entry.setTitle("title");
        entry.setAuthor("author");
        entry.setBody("body");

        repository.save(entry);

        assertEquals(1L, repository.count());
    }

    @Test
    public void updateSavedEntry_numberOfEntries1Test() {
        Entry entry = new Entry();
        entry.setTitle("title");
        entry.setAuthor("author");
        entry.setBody("body");

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
        Entry entry1 = new Entry();
        entry1.setTitle("title");
        entry1.setAuthor("author");
        entry1.setBody("body");
        repository.save(entry1);

        Entry entry2 = new Entry();
        entry2.setTitle("title");
        entry2.setAuthor("author2");
        entry2.setBody("body");
        repository.save(entry2);
        assertEquals(2L, repository.findAll().size());


        repository.delete(2);
        assertEquals(1L, repository.findAll().size());
    }

    @Test
    public void save2Entries_deleteFirstSavedEntryByEntry_numberOfEntries1Test() {
        Entry entry1 = new Entry();
        entry1.setTitle("title");
        entry1.setAuthor("author");
        entry1.setBody("body");
        repository.save(entry1);

        Entry entry2 = new Entry();
        entry2.setTitle("title");
        entry2.setAuthor("author2");
        entry2.setBody("body");
        repository.save(entry2);

        assertEquals(2L, repository.findAll().size());


        repository.delete(entry1);
        assertEquals(1L, repository.findAll().size());
    }
}