package de.gothaer.schweineservice.adapter.events;

import de.gothaer.schweineservice.adapter.dto.SchweinDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.SuperBuilder;


@Data
@AllArgsConstructor
@SuperBuilder
public class SchweinUpdatedEvent extends BaseEvent{

    private final SchweinDTO schweinDTO;

}
