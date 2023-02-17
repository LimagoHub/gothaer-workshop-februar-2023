package de.gothaer.schweineservice.adapter.commandhandler;

import de.gothaer.schweineservice.domain.aggregate.Schwein;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


public interface SchweinCommandHandler {

    void handleSchweinErfassen(Schwein schwein);
    void handleSchweinAendern(Schwein schwein);

    boolean handleSchweinLoeschen(String id);
    boolean handleSchweinFuettern(String id);
}
