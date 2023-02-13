package de.gothaer.smartbank24kreditantragregistrierung.adapter.events;


import de.gothaer.smartbank24kreditantragregistrierung.adapter.dto.KreditantragDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class KreditantragRegistriertEvent extends BaseEvent{
    private KreditantragDTO kreditantrag;
}
