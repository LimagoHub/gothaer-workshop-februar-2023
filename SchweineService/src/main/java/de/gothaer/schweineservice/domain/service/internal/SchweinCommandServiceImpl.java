package de.gothaer.schweineservice.domain.service.internal;

import de.gothaer.schweineservice.domain.aggregate.Schwein;
import de.gothaer.schweineservice.domain.repository.SchweineRepository;
import de.gothaer.schweineservice.domain.service.SchweinCommandService;
import de.gothaer.schweineservice.domain.service.SchweineServiceException;
import lombok.AllArgsConstructor;

import java.util.Optional;

@AllArgsConstructor
public class SchweinCommandServiceImpl implements SchweinCommandService {

    private final SchweineRepository repository;

    @Override
    public void speichern(Schwein schwein) throws SchweineServiceException {
        try {
            if(repository.exists(schwein.getId())) throw new SchweineServiceException("Schwein existiert bereits");
            repository.save(schwein);
        } catch (RuntimeException e) {
            throw new SchweineServiceException(e);
        }
    }

    @Override
    public void aendern(Schwein schwein) throws SchweineServiceException {
        try {
            if( ! repository.exists(schwein.getId())) throw new SchweineServiceException("Schwein existiert nicht");
            repository.save(schwein);
        } catch (RuntimeException e) {
            throw new SchweineServiceException(e);
        }
    }

    @Override
    public boolean loeschen(String id) throws SchweineServiceException {
        try {
            if(  repository.exists(id)) {
                repository.remove(id);
                return true;
            }
            return false;
        } catch (RuntimeException e) {
            throw new SchweineServiceException(e);
        }
    }

    @Override
    public boolean futtern(String id) throws SchweineServiceException {
        try {
            return repository.findById(id).map(this::futternUndSpeichern).isPresent();
        } catch (RuntimeException e) {
            throw new SchweineServiceException(e);
        }
    }

    private Schwein futternUndSpeichern(Schwein s) {
        s.futtern();
        repository.update(s);
        return s;
    }
}
