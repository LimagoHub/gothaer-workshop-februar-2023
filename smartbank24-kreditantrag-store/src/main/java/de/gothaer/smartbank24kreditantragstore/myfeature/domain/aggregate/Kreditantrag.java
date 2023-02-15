package de.gothaer.smartbank24kreditantragstore.myfeature.domain.aggregate;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter(AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Kreditantrag {

    private String creditApplicationId ;
    private String firstName;
    private String lastName;
    private String city;
    private LocalDateTime applicationDate ;
    private double monthlyIncome;
    private double monthlyExpenditure;
    private double creditSum;
    private LocalDateTime version;
    @Builder.Default
    private String scoringState ="in progress";

    @Builder.Default
    private String cityScoringState ="in progress";

    @Builder.Default
    private String applicationState ="in progress";

    public Statuswechsel behandlePositivesScoring() {
        if(! applicationState.equals("in progress")) return Statuswechsel.NO_CHANGE;
        if(! scoringState.equals("in progress")) return Statuswechsel.NO_CHANGE;

        if(scoringState.equals("in progress") && cityScoringState.equals("in progress")){
            scoringState = "Ok";
            return Statuswechsel.NO_CHANGE;
        }

        if(scoringState.equals("in progress") &&  cityScoringState.equals("Ok")){
            scoringState = "Ok";
            applicationState = "Accepted";
            return Statuswechsel.FINAL;
        }
        return Statuswechsel.NO_CHANGE;
    }

    public Statuswechsel behandleNegativesScoring() {
        if(! applicationState.equals("in progress")) return Statuswechsel.NO_CHANGE;
        if(! scoringState.equals("in progress")) return Statuswechsel.NO_CHANGE;

        scoringState = "abgelehnt";
        applicationState ="DENIED";
        return Statuswechsel.FINAL;
    }

    public Statuswechsel behandlePositivesCityScoring() {
        if(! applicationState.equals("in progress")) return Statuswechsel.NO_CHANGE;
        if(! cityScoringState.equals("in progress")) return Statuswechsel.NO_CHANGE;

        if(cityScoringState.equals("in progress") && scoringState.equals("in progress")){
            cityScoringState = "Ok";
            return Statuswechsel.NO_CHANGE;
        }

        if(cityScoringState.equals("in progress") &&  scoringState.equals("Ok")){
            cityScoringState = "Ok";
            applicationState = "Accepted";
            return Statuswechsel.FINAL;
        }
        return Statuswechsel.NO_CHANGE;

    }

    public Statuswechsel behandleNegativesCityScoring() {

        if(! applicationState.equals("in progress")) return Statuswechsel.NO_CHANGE;
        if(! cityScoringState.equals("in progress")) return Statuswechsel.NO_CHANGE;

        cityScoringState = "abgelehnt";
        applicationState ="DENIED";
        return Statuswechsel.FINAL;

    }

}
