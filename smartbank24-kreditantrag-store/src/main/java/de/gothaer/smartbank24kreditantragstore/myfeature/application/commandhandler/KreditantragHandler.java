package de.gothaer.smartbank24kreditantragstore.myfeature.application.commandhandler;


import de.gothaer.smartbank24kreditantragstore.myfeature.domain.aggregate.Kreditantrag;

public interface KreditantragHandler {
    void handleKreditantragRegistriert(Kreditantrag kreditantrag);
    void handleScoringPositiv(String id);
    void handleScoringNegativ(String id);
    void handleCityScoringPositiv(String id);
    void handleCityScoringNegativ(String id);
}
