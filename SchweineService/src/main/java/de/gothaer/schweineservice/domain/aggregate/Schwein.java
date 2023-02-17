package de.gothaer.schweineservice.domain.aggregate;


import lombok.*;

@Data
@Setter(AccessLevel.PRIVATE)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Schwein {
    private String id;
    private String name;
    private int gewicht;

    public void futtern() {
        setGewicht(getGewicht() + 1);
    }
}
