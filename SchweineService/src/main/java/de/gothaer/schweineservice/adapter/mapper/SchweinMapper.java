package de.gothaer.schweineservice.adapter.mapper;


import de.gothaer.schweineservice.adapter.repository.entity.SchweinEntity;
import de.gothaer.schweineservice.domain.aggregate.Schwein;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SchweinMapper {

	Schwein convert(SchweinEntity entity);
	SchweinEntity convert(Schwein schwein);
	Iterable<Schwein> convert(Iterable<SchweinEntity> entities);
}
