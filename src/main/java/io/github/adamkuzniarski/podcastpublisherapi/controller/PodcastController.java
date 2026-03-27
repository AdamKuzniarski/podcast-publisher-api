package io.github.adamkuzniarski.podcastpublisherapi.controller;

import io.github.adamkuzniarski.podcastpublisherapi.dto.PodcastResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PodcastController {

    @GetMapping("/api/podcasts")
    public List<PodcastResponse> getPodcasts() {
        return List.of(
                new PodcastResponse(
                        1L,
                        "Java Backend Basics",
                        "Ein Podcast über Springboot und Backend",
                        "Adam"
                ),
                new PodcastResponse(
                        2L,
                        "JavaScript Frontend Basics",
                        "Ein Podcast über React und Frontend",
                        "Adam"
                )
        );
    }
}
