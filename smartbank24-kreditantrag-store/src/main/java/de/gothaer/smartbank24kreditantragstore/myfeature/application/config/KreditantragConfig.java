package de.gothaer.smartbank24kreditantragstore.myfeature.application.config;


import de.gothaer.smartbank24kreditantragstore.myfeature.domain.event.LocalEventPublisher;
import de.gothaer.smartbank24kreditantragstore.myfeature.domain.service.KreditantragRepository;
import de.gothaer.smartbank24kreditantragstore.myfeature.domain.service.KreditantragService;
import de.gothaer.smartbank24kreditantragstore.myfeature.domain.service.internal.KreditantragServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KreditantragConfig {

    @Bean
    public KreditantragService createKreditantragService(KreditantragRepository repo, LocalEventPublisher publisher) {
        return new KreditantragServiceImpl(repo, publisher);
    }
}
