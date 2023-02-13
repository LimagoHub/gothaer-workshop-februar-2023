package de.gothaer.smartbank24kreditantragregistrierung.domain.event;

public interface LocalEventPublisher {

    void sende(KreditantragRegistriertLocalEvent event);
}
