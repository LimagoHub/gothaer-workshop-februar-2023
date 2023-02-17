package de.gothaer.schweineservice.adapter.controller;


import de.gothaer.schweineservice.adapter.commandhandler.SchweinCommandHandler;
import de.gothaer.schweineservice.adapter.dto.SchweinDTO;
import de.gothaer.schweineservice.adapter.mapper.SchweinDTOMapper;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1/schweine")
@AllArgsConstructor
public class SchweineCommandController {
    private final SchweinCommandHandler handler;
    private final SchweinDTOMapper mapper;




    @DeleteMapping(path="/{id}")
    public ResponseEntity<Void> delete(@PathVariable  String id)throws Exception{
        if(handler.handleSchweinLoeschen(id)) {

            return ResponseEntity.ok().build();
        }

        return ResponseEntity.notFound().build();
    }

    @PostMapping(path="", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> save(@Valid @RequestBody SchweinDTO dto, UriComponentsBuilder builder) throws Exception{
        handler.handleSchweinErfassen(mapper.convert(dto));
        UriComponents component = builder.path("/v1/schweine/{id}").buildAndExpand(dto.getId());
        return ResponseEntity.created(component.toUri()).build();

    }

    @PutMapping(path="/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> update(@PathVariable String id,@Valid  @RequestBody SchweinDTO dto) throws Exception {

        handler.handleSchweinAendern(mapper.convert(dto));

        return ResponseEntity.ok().build();
    }



    @PostMapping(path="/{id}/fuettere")
    public ResponseEntity<Void> feed(@PathVariable String id) throws Exception{
        if( handler.handleSchweinFuettern(id)){

            return ResponseEntity.ok().build();
        }

        return ResponseEntity.notFound().build();
    }



}