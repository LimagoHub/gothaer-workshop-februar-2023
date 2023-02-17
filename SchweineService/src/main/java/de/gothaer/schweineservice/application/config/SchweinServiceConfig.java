package de.gothaer.schweineservice.application.config;

import de.gothaer.schweineservice.domain.repository.SchweineRepository;
import de.gothaer.schweineservice.domain.service.SchweinCommandService;
import de.gothaer.schweineservice.domain.service.SchweinQueryService;
import de.gothaer.schweineservice.domain.service.internal.SchweinCommandServiceImpl;
import de.gothaer.schweineservice.domain.service.internal.SchweinQueryServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SchweinServiceConfig {

    @Bean
    public SchweinCommandService createSchweinCommandService(SchweineRepository repository) {
        return new SchweinCommandServiceImpl(repository);
    }

    @Bean
    public SchweinQueryService createSchweinQueryService(SchweineRepository repository) {
        return new SchweinQueryServiceImpl(repository);
    }
}
