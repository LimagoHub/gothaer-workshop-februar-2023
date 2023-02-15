package de.gothaer.smartbank24kreditantragstore.myfeature.domain.service;

import de.gothaer.smartbank24kreditantragstore.myfeature.domain.aggregate.Kreditantrag;

public interface KreditantragService {


    void speichereKreditantrag(Kreditantrag antrag) throws KreditantragServiceException;
    void verarbeitePositivesScoring(String id) throws KreditantragServiceException;
    void verarbeitePositivesCityScoring(String id) throws KreditantragServiceException;
    void verarbeiteNegativesScoring(String id) throws KreditantragServiceException;
    void verarbeiteNegativesCityScoring(String id) throws KreditantragServiceException;
    Kreditantrag findeKreditantragMitId(String id) throws KreditantragServiceException;
}
