package de.gothaer.smartbank24kreditantragstore.myfeature.adapter.mapper;


import de.gothaer.smartbank24kreditantragstore.myfeature.adapter.dto.KreditantragDTO;
import de.gothaer.smartbank24kreditantragstore.myfeature.domain.aggregate.Kreditantrag;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface KreditantragDTOMapper {
    KreditantragDTO convert(Kreditantrag kreditantrag);
    Kreditantrag convert(KreditantragDTO kreditantrag);

    Iterable<KreditantragDTO> convert(Iterable<Kreditantrag> antraege);
}
