package io.github.adamkuzniarski.podcastpublisherapi.repository;

import io.github.adamkuzniarski.podcastpublisherapi.model.Podcast;

import java.util.List;
import java.util.Optional;

public interface PodcastRepository {

    List<Podcast> findAll();
    Optional<Podcast> findById(Long id);
    Podcast save(Podcast podcast);
    boolean deleteById(Long id);
}
