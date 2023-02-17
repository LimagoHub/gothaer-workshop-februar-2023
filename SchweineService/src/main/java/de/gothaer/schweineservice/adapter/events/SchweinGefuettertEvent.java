package de.gothaer.schweineservice.adapter.events;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.SuperBuilder;


@Data
@AllArgsConstructor
@SuperBuilder
public class SchweinGefuettertEvent extends BaseEvent{

    private final String id;

}
