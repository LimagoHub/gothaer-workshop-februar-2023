package de.gothaer.smartbank24kreditantragregistrierung.domain.services.internal;


import de.gothaer.smartbank24kreditantragregistrierung.domain.KreditantragRepository;
import de.gothaer.smartbank24kreditantragregistrierung.domain.event.KreditantragRegistriertLocalEvent;
import de.gothaer.smartbank24kreditantragregistrierung.domain.event.LocalEventPublisher;
import de.gothaer.smartbank24kreditantragregistrierung.domain.model.Kreditantrag;
import de.gothaer.smartbank24kreditantragregistrierung.domain.services.KreditantragService;
import de.gothaer.smartbank24kreditantragregistrierung.domain.services.KreditantragServiceException;
import lombok.AllArgsConstructor;

import java.util.Optional;

@AllArgsConstructor
public class KreditantragServiceImpl implements KreditantragService {

    private final KreditantragRepository repo;
    private final LocalEventPublisher publisher;

    @Override
    public void register(Kreditantrag kreditantrag) throws KreditantragServiceException {
        try {
            if(repo.existenzPruefen(kreditantrag)) {
                throw new KreditantragServiceException("Upps");
            }
            repo.anlegen(kreditantrag);
            publisher.sende(KreditantragRegistriertLocalEvent.builder().kreditantrag(kreditantrag).build());
        } catch (RuntimeException e) {

            throw new  KreditantragServiceException("Upps", e);
        }
    }

    @Override
    public Optional<Kreditantrag> findById(String id) throws KreditantragServiceException {
        try {
            return repo.findeAntragNachId(id);
        } catch (Exception e) {
            throw new  KreditantragServiceException("Upps", e);
        }
    }

    @Override
    public Iterable<Kreditantrag> findAll() throws KreditantragServiceException {
        try {
            return repo.findeAlle();
        } catch (Exception e) {
            throw new  KreditantragServiceException("Upps", e);
        }
    }
}
