package de.gothaer.smartbank24kreditantragregistrierung;



import static com.tngtech.archunit.library.Architectures.onionArchitecture;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

@AnalyzeClasses(packagesOf = Smartbank24KreditantragRegistrierungApplication.class)
public class ArchUnitTest {

    @ArchTest
    public static final ArchRule myRule = onionArchitecture()
            .domainModels("de.gothaer.smartbank24kreditantragregistrierung.domain.model..", "de.gothaer.smartbank24kreditantragregistrierung.domain.event..")
            .domainServices("de.gothaer.smartbank24kreditantragregistrierung.domain.services..")
            .applicationServices(
                    "de.gothaer.smartbank24kreditantragregistrierung.application.config..",
                    "de.gothaer.smartbank24kreditantragregistrierung.application.commandhandler..",
                    "de.gothaer.smartbank24kreditantragregistrierung.application.queryreader..",
                    "de.gothaer.smartbank24kreditantragregistrierung.application.service..")
            .adapter( "adapter", "de.gothaer.smartbank24kreditantragregistrierung..")

            .allowEmptyShould(true);
}
