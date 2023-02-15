package de.gothaer.smartbank24kreditantragstore.myfeature.adapter.mapper;

import de.gothaer.smartbank24kreditantragstore.myfeature.adapter.event.KreditantragEvent;
import de.gothaer.smartbank24kreditantragstore.myfeature.domain.event.KreditAntragAcceptedLocalEvent;
import de.gothaer.smartbank24kreditantragstore.myfeature.domain.event.KreditantragDeniedLocalEvent;
import de.gothaer.smartbank24kreditantragstore.myfeature.domain.event.KreditantragPersistiertLocalEvent;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface KreditantragLocalEventToDomainEventMapper {

    KreditantragEvent convert(KreditantragPersistiertLocalEvent kreditantragPersistiertLocalEvent);
    KreditantragEvent convert(KreditAntragAcceptedLocalEvent kreditAntragAcceptedLocalEvent);
    KreditantragEvent convert(KreditantragDeniedLocalEvent kreditantragDeniedLocalEvent);
}
