package de.gothaer.smartbank24kreditantragregistrierung.application.queryreader.internal;

import de.gothaer.smartbank24kreditantragregistrierung.application.queryreader.KreditantragReader;
import de.gothaer.smartbank24kreditantragregistrierung.domain.model.Kreditantrag;
import de.gothaer.smartbank24kreditantragregistrierung.domain.services.KreditantragService;
import de.gothaer.smartbank24kreditantragregistrierung.domain.services.KreditantragServiceException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class KreditantragReaderImpl implements KreditantragReader {

    private final KreditantragService service;

    @Override
    public Optional<Kreditantrag> findById(String id) throws KreditantragServiceException {
        return service.findById(id);
    }

    @Override
    public Iterable<Kreditantrag> findAll() throws KreditantragServiceException {
        return service.findAll();
    }
}
