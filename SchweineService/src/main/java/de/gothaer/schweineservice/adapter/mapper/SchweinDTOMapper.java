package de.gothaer.schweineservice.adapter.mapper;


import de.gothaer.schweineservice.adapter.dto.SchweinDTO;
import de.gothaer.schweineservice.domain.aggregate.Schwein;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SchweinDTOMapper {
    public Schwein convert(SchweinDTO dto);
    public SchweinDTO convert(Schwein schwein);
    public Iterable<SchweinDTO> convert(Iterable<Schwein> schweine);
}
