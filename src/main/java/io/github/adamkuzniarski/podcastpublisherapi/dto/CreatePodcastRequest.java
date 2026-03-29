package io.github.adamkuzniarski.podcastpublisherapi.dto;

public record CreatePodcastRequest(
        String title,
        String description,
        String author
) {
}
