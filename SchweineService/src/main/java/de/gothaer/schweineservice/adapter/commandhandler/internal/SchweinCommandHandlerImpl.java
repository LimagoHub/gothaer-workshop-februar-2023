package de.gothaer.schweineservice.adapter.commandhandler.internal;

import de.gothaer.schweineservice.adapter.commandhandler.SchweinCommandHandler;
import de.gothaer.schweineservice.adapter.events.emitter.EventEmitter;
import de.gothaer.schweineservice.domain.aggregate.Schwein;
import de.gothaer.schweineservice.domain.service.SchweinCommandService;
import de.gothaer.schweineservice.domain.service.SchweineServiceException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
@Transactional
public class SchweinCommandHandlerImpl implements SchweinCommandHandler {

    private final SchweinCommandService service;
    private final EventEmitter emitter;
    @Override
    public void handleSchweinErfassen(Schwein schwein) {
        try {
            service.speichern(schwein);
            emitter.handleSchweinPersistiert(schwein);
        } catch (SchweineServiceException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void handleSchweinAendern(Schwein schwein) {
        try {
            service.aendern(schwein);
            emitter.handleSchweingeaendert(schwein);
        } catch (SchweineServiceException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean handleSchweinLoeschen(String id) {
        try {
            if(service.loeschen(id)) {
                emitter.handleSchweingeloescht(id);
                return true;
            }
            return false;
        } catch (SchweineServiceException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean handleSchweinFuettern(String id) {
        try {
            if(service.futtern(id)) {
                emitter.handleSchweingefuettert(id);
                return true;
            }
            return false;
        } catch (SchweineServiceException e) {
            throw new RuntimeException(e);
        }
    }
}
