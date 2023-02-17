package de.gothaer.schweineservice.domain.repository;

import de.gothaer.schweineservice.domain.aggregate.Schwein;

import java.util.Optional;

public interface SchweineRepository {

    void save(Schwein schwein);
    void update(Schwein schwein);

    void remove(String id);
    boolean exists(String id);

    Optional<Schwein> findById(String id);

    Iterable<Schwein> findAll();


}
