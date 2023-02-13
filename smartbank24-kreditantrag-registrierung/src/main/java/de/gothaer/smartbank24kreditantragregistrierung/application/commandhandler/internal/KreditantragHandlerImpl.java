package de.gothaer.smartbank24kreditantragregistrierung.application.commandhandler.internal;


import de.gothaer.smartbank24kreditantragregistrierung.application.commandhandler.KreditantragHandler;
import de.gothaer.smartbank24kreditantragregistrierung.domain.model.Kreditantrag;
import de.gothaer.smartbank24kreditantragregistrierung.domain.services.KreditantragService;
import de.gothaer.smartbank24kreditantragregistrierung.domain.services.KreditantragServiceException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = KreditantragServiceException.class, propagation = Propagation.REQUIRED)
@AllArgsConstructor
@Slf4j
public class KreditantragHandlerImpl implements KreditantragHandler {



    private final KreditantragService service;


    @Override
    public void handle(Kreditantrag kreditantrag) throws KreditantragServiceException {
        try {

            service.register(kreditantrag);

            log.info("Kreditantrag mit der ID '{}' erfolgreich registriert.", kreditantrag.getCreditApplicationId());
        } catch (KreditantragServiceException e) {
            // Misserfolg feuern
            log.error("Fehler beim Registrieren des Kreditantrags mit der ID '{}'", kreditantrag.getCreditApplicationId(), e);
            throw e;
        }
    }


}
