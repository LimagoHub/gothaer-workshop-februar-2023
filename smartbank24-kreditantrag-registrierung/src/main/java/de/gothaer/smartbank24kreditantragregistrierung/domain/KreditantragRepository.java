package de.gothaer.smartbank24kreditantragregistrierung.domain;


import de.gothaer.smartbank24kreditantragregistrierung.domain.model.Kreditantrag;

import java.util.Optional;

public interface KreditantragRepository {
    void anlegen(Kreditantrag antrag);

    boolean existenzPruefen(Kreditantrag k);

    Optional<Kreditantrag> findeAntragNachId(String id);

    Iterable<Kreditantrag> findeAlle();
}
