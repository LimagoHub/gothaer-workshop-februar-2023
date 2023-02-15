package de.gothaer.smartbank24kreditantragstore.myfeature.domain.event;


import de.gothaer.smartbank24kreditantragstore.myfeature.domain.aggregate.Kreditantrag;
import lombok.*;

@Getter
@Setter(AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class KreditantragDeniedLocalEvent {

    private Kreditantrag kreditantrag;
}
