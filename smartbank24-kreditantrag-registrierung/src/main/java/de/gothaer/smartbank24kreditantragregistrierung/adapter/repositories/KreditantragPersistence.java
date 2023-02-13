package de.gothaer.smartbank24kreditantragregistrierung.adapter.repositories;


import de.gothaer.smartbank24kreditantragregistrierung.adapter.repositories.entities.KreditantragEntity;
import org.springframework.data.repository.CrudRepository;

public interface KreditantragPersistence extends CrudRepository<KreditantragEntity, String> {
}
