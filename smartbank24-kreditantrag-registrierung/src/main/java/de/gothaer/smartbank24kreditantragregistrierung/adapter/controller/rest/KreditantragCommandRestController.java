package de.gothaer.smartbank24kreditantragregistrierung.adapter.controller.rest;

import de.gothaer.smartbank24kreditantragregistrierung.adapter.dto.KreditantragDTO;

import de.gothaer.smartbank24kreditantragregistrierung.adapter.mapper.KreditantragDTOMapper;
import de.gothaer.smartbank24kreditantragregistrierung.application.commandhandler.KreditantragHandler;
import de.gothaer.smartbank24kreditantragregistrierung.domain.services.KreditantragServiceException;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(path="/api/v1/kreditantraege")
@AllArgsConstructor
public class KreditantragCommandRestController {

    private final KreditantragHandler kreditantragHandler;
    private final KreditantragDTOMapper mapper;

    @ApiResponse(responseCode = "204", description = "Kreditantrag wurde registriert")
    @ApiResponse(responseCode = "400", description = "Bad Request (moeglicherweise bereits erfasst)" )
    @ApiResponse(responseCode = "500", description = "Interner Serverfehler")

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> register(@Valid @RequestBody KreditantragDTO kreditantragDTO) throws KreditantragServiceException {


        kreditantragHandler.handle(mapper.convert(kreditantragDTO));
        return ResponseEntity.noContent().build();
    }
}
