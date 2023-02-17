package de.gothaer.schweineservice.domain.service.internal;

import de.gothaer.schweineservice.domain.aggregate.Schwein;
import de.gothaer.schweineservice.domain.repository.SchweineRepository;
import de.gothaer.schweineservice.domain.service.SchweinQueryService;
import de.gothaer.schweineservice.domain.service.SchweineServiceException;
import lombok.AllArgsConstructor;

import java.util.Optional;

@AllArgsConstructor
public class SchweinQueryServiceImpl implements SchweinQueryService {

    private final SchweineRepository repository;
    @Override
    public Iterable<Schwein> findeAlle() throws SchweineServiceException {
        try {
            return repository.findAll();
        } catch (RuntimeException e) {
            throw new SchweineServiceException(e);
        }
    }

    @Override
    public Optional<Schwein> findNachId(String id) throws SchweineServiceException {
        try {
            return repository.findById(id);
        } catch (RuntimeException e) {
            throw new SchweineServiceException(e);
        }
    }
}
