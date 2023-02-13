package de.gothaer.smartbank24kreditantragregistrierung.application.service.internal;

import de.gothaer.smartbank24kreditantragregistrierung.domain.event.KreditantragRegistriertLocalEvent;
import de.gothaer.smartbank24kreditantragregistrierung.domain.event.LocalEventPublisher;
import lombok.AllArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class LocalEventPublisherImpl implements LocalEventPublisher {

    private final ApplicationEventPublisher publisher;

    @Override
    public void sende(KreditantragRegistriertLocalEvent event) {
        publisher.publishEvent(event);
    }
}
