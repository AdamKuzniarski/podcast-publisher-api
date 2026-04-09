package io.github.adamkuzniarski.podcastpublisherapi.model;

public class Podcast {

    private final Long id;
    private final String title;
    private final String description;
    private final String author;

    public Podcast(Long id, String title, String description, String author) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.author = author;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;

    }

    public String getDescription() {
        return description;
    }
    public String getAuthor() {
        return author;
    }
}
