package de.gothaer.smartbank24kreditantragregistrierung.adapter.mapper;

import de.gothaer.smartbank24kreditantragregistrierung.adapter.events.KreditantragRegistriertEvent;
import de.gothaer.smartbank24kreditantragregistrierung.domain.event.KreditantragRegistriertLocalEvent;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface KreditantragLocalEventToDomainEventMapper {

    KreditantragRegistriertEvent convert(KreditantragRegistriertLocalEvent kreditantragRegistriertLocalEvent);
}
