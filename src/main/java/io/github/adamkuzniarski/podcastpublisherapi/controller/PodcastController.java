package io.github.adamkuzniarski.podcastpublisherapi.controller;

import io.github.adamkuzniarski.podcastpublisherapi.dto.PodcastResponse;
import io.github.adamkuzniarski.podcastpublisherapi.service.PodcastService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PodcastController {

    private final PodcastService podcastService;

    public PodcastController(PodcastService podcastService) {
        this.podcastService = podcastService;
    }

    @GetMapping("/api/podcasts")
        public List<PodcastResponse> getPodcasts() {
            return podcastService.getPodcasts();
        }
}
