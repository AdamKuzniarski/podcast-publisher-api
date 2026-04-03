package io.github.adamkuzniarski.podcastpublisherapi.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CreatePodcastRequest(
@NotBlank(message = "Title must not be blank")
@Size(max = 100, message = "Title must not exceed 100 characters")
String title,

@NotBlank(message = "Description must not be blank")
@Size(max = 500, message = "Descriptoion must not exceed 500 characters")
String description,

@NotBlank(message = "Author must not be blank")
@Size(max = 50, message = "Author must not exceed 50 characters")
String author
) {
}
