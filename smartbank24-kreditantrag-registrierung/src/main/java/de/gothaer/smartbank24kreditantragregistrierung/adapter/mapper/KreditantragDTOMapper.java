package de.gothaer.smartbank24kreditantragregistrierung.adapter.mapper;


import de.gothaer.smartbank24kreditantragregistrierung.adapter.dto.KreditantragDTO;
import de.gothaer.smartbank24kreditantragregistrierung.domain.model.Kreditantrag;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface KreditantragDTOMapper {
    KreditantragDTO convert(Kreditantrag kreditantrag);
    Kreditantrag convert(KreditantragDTO kreditantrag);

    Iterable<KreditantragDTO> convert(Iterable<Kreditantrag> antraege);
}
