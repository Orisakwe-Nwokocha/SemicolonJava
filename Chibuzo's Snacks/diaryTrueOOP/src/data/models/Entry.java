package data.models;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Entry {
    private int id;
    private String title;
    private String body;
    private LocalDateTime creationDate = LocalDateTime.now();
    private String author;

    public Entry() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }


    @Override
    public String toString() {
        String asterisk = "*".repeat(10);
        String dateCreated = creationDate.format(DateTimeFormatter.ofPattern("dd/MMM/yyyy HH:mm:ss a"));
        String format = "%s%nGist %d%nDate Created: %s%nGossip Title:%n%s%nLatest Gist:%n%s%n%s%n";

        return String.format(format, asterisk, id, dateCreated, title, body, asterisk);
    }
}
