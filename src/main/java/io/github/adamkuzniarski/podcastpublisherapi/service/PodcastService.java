package io.github.adamkuzniarski.podcastpublisherapi.service;

import io.github.adamkuzniarski.podcastpublisherapi.dto.CreatePodcastRequest;
import io.github.adamkuzniarski.podcastpublisherapi.dto.PodcastResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PodcastService {

    private final List<PodcastResponse> podcasts = new ArrayList<>();

    public PodcastService() {
        podcasts.add(new PodcastResponse(1L, "Java Backend Basics", "Ein Podcast über Backend-Lernen", "Adam"));
        podcasts.add(new PodcastResponse(2L, "Spring Boot Insights", "Ein Podcast über Spring
    }

    public List<PodcastResponse> getPodcasts() {
        return podcasts;
    }

    public PodcastResponse createPodcast(CreatePodcastRequest request) {
        Long newId = (long) (podcasts.size() + 1);

        PodcastResponse newPodcast = new PodcastResponse(
                newId,
                request.title(),
                request.description(),
                request.author()
        );
        podcasts.add(newPodcast);
        return newPodcast;
    }
}