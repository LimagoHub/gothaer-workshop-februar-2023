package de.gothaer.smartbank24kreditantragstore.myfeature.adapter.event;


import de.gothaer.smartbank24kreditantragstore.myfeature.adapter.dto.KreditantragDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class KreditantragEvent extends BaseEvent{
    private KreditantragDTO kreditantrag;
}
