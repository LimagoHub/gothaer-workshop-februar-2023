package de.gothar.smartbank24kreditantragscoring.domain.aggregates;

import lombok.*;

@Getter
@Setter(AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@Builder
public class Kreditantrag {
    private String creditApplicationId ;


    private double monthlyIncome;

    private double monthlyExpenditure;

    private double creditSum;

    public boolean isKreditwuerdig() {
        return creditSum < (monthlyIncome-monthlyExpenditure) * 10.0;
    }
}
