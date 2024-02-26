package oopDiary;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Entry {
    private final int id;
    private String title;
    private String body;
    private final LocalDateTime dateCreated;

    public Entry(int id, String title, String body) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.dateCreated = LocalDateTime.now();
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public String getDateCreated() {
        return formatDateCreated()[0];
    }

    private String[] formatDateCreated() {
        String currentDateAndTime = dateCreated.format(DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss a"));
        return currentDateAndTime.split(" ");
    }

    @Override
    public String toString() {
        return String.format("Entry[%n\tid ===> %d%n\tdate created ===> %s%n\ttitle ===> %s%n\tbody ===> %s%n\t]",
                id, getDateCreated(), title, body);
    }

    public void updateTitle(String newTitle) {
        this.title = newTitle;
    }

    public void updateBody(String newBody) {
        this.body = newBody;
    }
}
