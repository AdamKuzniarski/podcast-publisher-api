package io.github.adamkuzniarski.podcastpublisherapi.dto;

public record PodcastResponse(
        Long id,
        String title,
        String description,
        String author
) {
}
