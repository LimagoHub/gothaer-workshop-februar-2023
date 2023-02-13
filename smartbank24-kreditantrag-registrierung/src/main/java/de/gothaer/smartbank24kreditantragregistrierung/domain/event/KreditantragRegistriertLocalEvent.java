package de.gothaer.smartbank24kreditantragregistrierung.domain.event;

import de.gothaer.smartbank24kreditantragregistrierung.domain.model.Kreditantrag;
import lombok.*;

@Getter
@Setter(AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class KreditantragRegistriertLocalEvent {

    private Kreditantrag kreditantrag;
}
