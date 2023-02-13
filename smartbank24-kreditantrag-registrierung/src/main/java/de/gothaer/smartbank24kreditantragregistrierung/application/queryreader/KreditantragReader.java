package de.gothaer.smartbank24kreditantragregistrierung.application.queryreader;

import de.gothaer.smartbank24kreditantragregistrierung.domain.model.Kreditantrag;
import de.gothaer.smartbank24kreditantragregistrierung.domain.services.KreditantragServiceException;

import java.util.Optional;

public interface KreditantragReader {

    public Optional<Kreditantrag> findById(String id)throws KreditantragServiceException;
    public Iterable<Kreditantrag> findAll()throws KreditantragServiceException ;
}
