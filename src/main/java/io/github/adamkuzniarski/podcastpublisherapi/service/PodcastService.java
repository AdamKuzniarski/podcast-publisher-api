package io.github.adamkuzniarski.podcastpublisherapi.service;

import io.github.adamkuzniarski.podcastpublisherapi.dto.CreatePodcastRequest;
import io.github.adamkuzniarski.podcastpublisherapi.dto.PodcastResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PodcastService {

    public List<PodcastResponse> getPodcasts() {
        return List.of(
                new PodcastResponse(1L, "Java Backend Basics","Ein Podcast über Backend-Lernen","Adam"),
                new PodcastResponse(2L, "Spring Boot Insights","Ein Podcast über Spring Boot","Adam")
        );
    }

    public PodcastResponse createPodcast(CreatePodcastRequest request){
        return new PodcastResponse(
                3L,
                request.title(),
                request.description(),
                request.author()
        );
    }
}
