package de.gothaer.smartbank24kreditantragstore.myfeature.adapter.repositories;


import de.gothaer.smartbank24kreditantragstore.myfeature.adapter.repositories.entities.KreditantragEntity;
import org.springframework.data.repository.CrudRepository;

public interface KreditantragPersistence extends CrudRepository<KreditantragEntity, String> {
}
