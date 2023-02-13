package de.gothaer.smartbank24kreditantragregistrierung.application.commandhandler;


import de.gothaer.smartbank24kreditantragregistrierung.domain.model.Kreditantrag;
import de.gothaer.smartbank24kreditantragregistrierung.domain.services.KreditantragServiceException;

public interface KreditantragHandler {
    void handle(Kreditantrag kreditantrag) throws KreditantragServiceException;
}
