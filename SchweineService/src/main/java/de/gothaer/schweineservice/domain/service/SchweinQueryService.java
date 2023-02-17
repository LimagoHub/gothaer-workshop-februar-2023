package de.gothaer.schweineservice.domain.service;

import de.gothaer.schweineservice.domain.aggregate.Schwein;

import java.util.Optional;

public interface SchweinQueryService {

    Iterable<Schwein> findeAlle() throws SchweineServiceException;
    Optional<Schwein> findNachId(String id) throws SchweineServiceException;
}
