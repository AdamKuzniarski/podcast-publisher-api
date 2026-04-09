package io.github.adamkuzniarski.podcastpublisherapi.service;

import io.github.adamkuzniarski.podcastpublisherapi.dto.CreatePodcastRequest;
import io.github.adamkuzniarski.podcastpublisherapi.dto.PodcastResponse;
import io.github.adamkuzniarski.podcastpublisherapi.model.Podcast;
import io.github.adamkuzniarski.podcastpublisherapi.repository.PodcastRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PodcastService {

    private final PodcastRepository podcastRepository;

    public PodcastService(PodcastRepository podcastRepository) {
        this.podcastRepository = podcastRepository;

        sendInitialData();
    }

    public List<PodcastResponse> getPodcasts() {
        List<PodcastResponse> responses = new ArrayList<>();

        for (Podcast podcast : podcastRepository.findAll()) {
            responses.add(mapToResponse(podcast));
        }
        return responses;
    }

    public PodcastResponse createPodcast(CreatePodcastRequest request) {
        Podcast podcastToSave = new Podcast(
                null,
                request.title(),
                request.description(),
                request.author()
        );
        Podcast savePodcast = podcastRepository.save(podcastToSave);
        return mapToResponse(savePodcast);
    }

    private PodcastResponse mapToResponse(Podcast podcast) {
        return new PodcastResponse(
                podcast.getId(),
                podcast.getTitle(),
                podcast.getDescription(),
                podcast.getAuthor()
        );
    }

    private void sendInitialData() {
        if(!podcastRepository.findAll().isEmpty()) {
            return;
        }

        podcastRepository.save(new Podcast(
                null,
                "Java Backend Basics",
                "Ein Podcast über Backend-Lernen",
                "Adam"
        ));

        podcastRepository.save(new Podcast(
                null,
                "Spring Boot Insights",
                "Ein Podcast über Spring",
                "Adam"
        ));

    }
}