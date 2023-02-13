package de.gothaer.smartbank24kreditantragregistrierung.adapter.repositories.impl;


import de.gothaer.smartbank24kreditantragregistrierung.adapter.mapper.KreditantragMapper;
import de.gothaer.smartbank24kreditantragregistrierung.adapter.repositories.KreditantragPersistence;
import de.gothaer.smartbank24kreditantragregistrierung.domain.KreditantragRepository;
import de.gothaer.smartbank24kreditantragregistrierung.domain.model.Kreditantrag;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@AllArgsConstructor
public class KreditantragRepositoryImpl implements KreditantragRepository {

    private final KreditantragPersistence persistence;
    private final KreditantragMapper mapper;

    @Override
    public void anlegen(Kreditantrag antrag) {
        persistence.save(mapper.convert(antrag));
    }

    @Override
    public boolean existenzPruefen(Kreditantrag k) {
        return persistence.existsById(k.getCreditApplicationId());
    }

    @Override
    public Optional<Kreditantrag> findeAntragNachId(String id) {
        return persistence.findById(id).map(mapper::convert);
    }

    @Override
    public Iterable<Kreditantrag> findeAlle() {
        return mapper.convert(persistence.findAll());
    }
}
