package io.github.adamkuzniarski.podcastpublisherapi.repository;

import io.github.adamkuzniarski.podcastpublisherapi.model.Podcast;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class InMemoryPodcastRepository implements PodcastRepository {

    private final Map<Long, Podcast> podcastsById = new LinkedHashMap<>();
    private final AtomicLong idSequence = new AtomicLong(0);

    @Override
    public List<Podcast> findAll() {
        return new ArrayList<>(podcastsById.values());
    }

    @Override
    public Optional<Podcast> findById(Long id) {
        return Optional.ofNullable(podcastsById.get(id));
    }

    @Override
    public Podcast save(Podcast podcast) {
        Podcast storedPodcast = podcast;

        if (podcast.getId() == null) {
            long newId = idSequence.incrementAndGet();

            storedPodcast = new Podcast(newId, podcast.getTitle(), podcast.getDescription(), podcast.getAuthor());
        }

        podcastsById.put(storedPodcast.getId(), storedPodcast);
        return storedPodcast;
    }

    @Override
    public boolean deleteById(Long id) {
        return podcastsById.remove(id) != null;
    }
}
