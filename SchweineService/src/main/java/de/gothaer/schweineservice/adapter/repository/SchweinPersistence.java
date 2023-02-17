package de.gothaer.schweineservice.adapter.repository;

import de.gothaer.schweineservice.adapter.repository.entity.SchweinEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface SchweinPersistence extends CrudRepository<SchweinEntity, String> {

    @Query("update SchweinEntity s set s.gewicht = :gewicht where s.id = :id")
    void update(String id, String gewicht);

}
