package de.gothaer.smartbank24kreditantragregistrierung.adapter.events.emitter;


import de.gothaer.smartbank24kreditantragregistrierung.adapter.mapper.KreditantragLocalEventToDomainEventMapper;
import de.gothaer.smartbank24kreditantragregistrierung.domain.event.KreditantragRegistriertLocalEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EventEmitter {

    private static final String SUPPLIER_BINDIN_NAME = "kreditantrag-registriert-out-0";
    private final StreamBridge bridge;
    private final KreditantragLocalEventToDomainEventMapper mapper;

    @EventListener
    public void handle(KreditantragRegistriertLocalEvent event){
        bridge.send(SUPPLIER_BINDIN_NAME, mapper.convert(event));
    }
}
