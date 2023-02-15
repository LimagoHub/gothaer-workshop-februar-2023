package de.gothaer.smartbank24kreditantragstore.myfeature.domain.event;

public interface LocalEventPublisher {

    void sende(KreditantragPersistiertLocalEvent event);
    void sende(KreditAntragAcceptedLocalEvent event);
    void sende(KreditantragDeniedLocalEvent event);

}
