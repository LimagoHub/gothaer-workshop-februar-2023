package de.gothaer.smartbank24kreditantragstore.myfeature.application.internal;

import de.gothaer.smartbank24kreditantragstore.myfeature.domain.event.KreditAntragAcceptedLocalEvent;
import de.gothaer.smartbank24kreditantragstore.myfeature.domain.event.KreditantragDeniedLocalEvent;
import de.gothaer.smartbank24kreditantragstore.myfeature.domain.event.KreditantragPersistiertLocalEvent;
import de.gothaer.smartbank24kreditantragstore.myfeature.domain.event.LocalEventPublisher;
import lombok.AllArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class LocalEventPublisherImpl implements LocalEventPublisher {

    private final ApplicationEventPublisher publisher;

    @Override
    public void sende(KreditantragPersistiertLocalEvent event) {
        publisher.publishEvent(event);
    }

    @Override
    public void sende(KreditAntragAcceptedLocalEvent event) {
        publisher.publishEvent(event);
    }

    @Override
    public void sende(KreditantragDeniedLocalEvent event) {
        publisher.publishEvent(event);
    }
}
