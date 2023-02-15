package de.gothaer.smartbank24kreditantragcityscoring.domain.aggregate;

import lombok.*;

@Getter
@Setter(AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Kreditantrag {

    private String creditApplicationId ;
    private String city;

    public boolean isGenehmigungsfaehig() {
        return ! ("münchen".equalsIgnoreCase(city) || "muenchen".equalsIgnoreCase(city));
    }

}
