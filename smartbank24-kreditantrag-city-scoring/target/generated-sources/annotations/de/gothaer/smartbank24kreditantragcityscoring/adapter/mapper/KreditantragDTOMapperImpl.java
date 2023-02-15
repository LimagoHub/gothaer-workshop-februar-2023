package de.gothaer.smartbank24kreditantragcityscoring.adapter.mapper;

import de.gothaer.smartbank24kreditantragcityscoring.adapter.dtos.KreditantragDTO;
import de.gothaer.smartbank24kreditantragcityscoring.domain.aggregate.Kreditantrag;
import de.gothaer.smartbank24kreditantragcityscoring.domain.aggregate.Kreditantrag.KreditantragBuilder;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-02-15T16:09:04+0100",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 17.0.4.1 (Eclipse Adoptium)"
)
@Component
public class KreditantragDTOMapperImpl implements KreditantragDTOMapper {

    @Override
    public Kreditantrag convert(KreditantragDTO kreditantragDTO) {
        if ( kreditantragDTO == null ) {
            return null;
        }

        KreditantragBuilder kreditantrag = Kreditantrag.builder();

        kreditantrag.creditApplicationId( kreditantragDTO.getCreditApplicationId() );
        kreditantrag.city( kreditantragDTO.getCity() );

        return kreditantrag.build();
    }
}
