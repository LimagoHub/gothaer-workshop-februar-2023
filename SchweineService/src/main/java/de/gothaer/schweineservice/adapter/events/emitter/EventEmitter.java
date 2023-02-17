package de.gothaer.schweineservice.adapter.events.emitter;

import de.gothaer.schweineservice.adapter.events.SchweinDeletedEvent;
import de.gothaer.schweineservice.adapter.events.SchweinGefuettertEvent;
import de.gothaer.schweineservice.adapter.events.SchweinPersistedEvent;
import de.gothaer.schweineservice.adapter.events.SchweinUpdatedEvent;
import de.gothaer.schweineservice.adapter.mapper.SchweinDTOMapper;
import de.gothaer.schweineservice.domain.aggregate.Schwein;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EventEmitter {

    private static final String SCHWEIN_PERSISTIERT = "schweinErfasst-out-0";
    private static final String SCHWEIN_UPDATED = "schweinGeaendert-out-0";
    private static final String SCHWEIN_DELETED = "schweinGeloescht-out-0";

    private static final String SCHWEIN_GEFUETTERT = "schweinGefuettert-out-0";
    private final StreamBridge bridge;
    private final SchweinDTOMapper mapper;


    public void handleSchweinPersistiert(Schwein schwein){
        SchweinPersistedEvent event = SchweinPersistedEvent.builder().schweinDTO(mapper.convert(schwein)).build();
        bridge.send(SCHWEIN_PERSISTIERT, event);
    }

    public void handleSchweingeaendert(Schwein schwein){
        SchweinUpdatedEvent event = SchweinUpdatedEvent.builder().schweinDTO(mapper.convert(schwein)).build();
        bridge.send(SCHWEIN_UPDATED, event);
    }

    public void handleSchweingeloescht(String id){
        SchweinDeletedEvent event = SchweinDeletedEvent.builder().id(id).build();
        bridge.send(SCHWEIN_DELETED, event);
    }

    public void handleSchweingefuettert(String id){
        SchweinGefuettertEvent event = SchweinGefuettertEvent.builder().id(id).build();
        bridge.send(SCHWEIN_GEFUETTERT, event);
    }
}