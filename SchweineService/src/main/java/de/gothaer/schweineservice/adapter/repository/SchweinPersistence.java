package de.gothaer.schweineservice.adapter.repository;

import de.gothaer.schweineservice.adapter.repository.entity.SchweinEntity;
import org.springframework.data.repository.CrudRepository;

public interface SchweinPersistence extends CrudRepository<SchweinEntity, String> {
}
