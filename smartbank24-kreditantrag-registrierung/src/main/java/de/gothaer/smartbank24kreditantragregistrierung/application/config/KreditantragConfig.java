package de.gothaer.smartbank24kreditantragregistrierung.application.config;


import de.gothaer.smartbank24kreditantragregistrierung.domain.KreditantragRepository;
import de.gothaer.smartbank24kreditantragregistrierung.domain.event.LocalEventPublisher;
import de.gothaer.smartbank24kreditantragregistrierung.domain.services.KreditantragService;
import de.gothaer.smartbank24kreditantragregistrierung.domain.services.internal.KreditantragServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KreditantragConfig {

    @Bean
    public KreditantragService createKreditantragService(KreditantragRepository repo, LocalEventPublisher publisher) {
        return new KreditantragServiceImpl(repo, publisher);
    }
}
