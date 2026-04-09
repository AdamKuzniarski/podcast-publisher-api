package io.github.adamkuzniarski.podcastpublisherapi.repository;

import io.github.adamkuzniarski.podcastpublisherapi.model.Podcast;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

public class InMemoryPodcastRepository  implements PodcastRepository{

    private final Map<Long, Podcast> podcastsById = new LinkedHashMap<>();
    private final AtomicLong idSequence = new AtomicLong(0);

    @Override
    public List<Podcast> findAll() {
    return new ArrayList<>(podcastsById.values());
    }

    @Override
    public Optional<Podcast> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Podcast save(Podcast podcast) {
        return null;
    }

    @Override
    public boolean deleteById(Long id) {
        return false;
    }
}
