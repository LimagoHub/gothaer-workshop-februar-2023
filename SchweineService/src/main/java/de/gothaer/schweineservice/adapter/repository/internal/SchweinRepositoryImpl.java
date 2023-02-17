package de.gothaer.schweineservice.adapter.repository.internal;


import de.gothaer.schweineservice.adapter.mapper.SchweinDTOMapper;
import de.gothaer.schweineservice.adapter.mapper.SchweinMapper;
import de.gothaer.schweineservice.adapter.repository.SchweinPersistence;
import de.gothaer.schweineservice.domain.aggregate.Schwein;
import de.gothaer.schweineservice.domain.repository.SchweineRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Repository
@AllArgsConstructor
public class SchweinRepositoryImpl implements SchweineRepository {

    private final SchweinPersistence persistence;
    private final SchweinMapper mapper;



    @Override
    public void save(Schwein schwein) {
        persistence.save(mapper.convert(schwein));
    }

    @Override
    public void update(Schwein schwein) {
        persistence.save(mapper.convert(schwein));
    }

    @Override
    public void remove(String id) {
        persistence.deleteById(id);
    }

    @Override
    public boolean exists(String id) {
        return persistence.existsById(id);
    }

    @Override
    public Optional<Schwein> findById(String id) {
        return persistence.findById(id).map(mapper::convert);
    }

    @Override
    public Iterable<Schwein> findAll() {
        return mapper.convert(persistence.findAll());
    }
}
