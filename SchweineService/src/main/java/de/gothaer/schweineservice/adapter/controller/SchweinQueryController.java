package de.gothaer.schweineservice.adapter.controller;

import de.gothaer.schweineservice.adapter.dto.SchweinDTO;
import de.gothaer.schweineservice.adapter.mapper.SchweinDTOMapper;
import de.gothaer.schweineservice.domain.service.SchweinQueryService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/v1/schweine")
@AllArgsConstructor
public class SchweinQueryController {

    private final SchweinQueryService service;
    private final SchweinDTOMapper mapper;

    @ApiResponse(responseCode = "200", description = "Schwein wurde gefunden")
    @ApiResponse(responseCode = "404", description = "Schwein wurde nicht gefunden")
    @ApiResponse(responseCode = "400", description = "Bad Request" )
    @ApiResponse(responseCode = "500", description = "Interner Serverfehler")
    @GetMapping(path= "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<SchweinDTO> findeSchweinByID(@PathVariable String id) throws Exception{

        return ResponseEntity.of(service.findNachId(id).map(mapper::convert));

    }

    @ApiResponse(responseCode = "200", description = "Liste wurde erstellt")
    @ApiResponse(responseCode = "400", description = "Bad Request" )
    @ApiResponse(responseCode = "500", description = "Interner Serverfehler")
    @GetMapping(path= "", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Iterable<SchweinDTO>> findAll(
            @RequestParam(required = false) String name,
            @RequestParam (required = false, defaultValue = "0") int gewicht
    )throws Exception{



        return ResponseEntity.ok(mapper.convert(service.findeAlle()));

    }
}
