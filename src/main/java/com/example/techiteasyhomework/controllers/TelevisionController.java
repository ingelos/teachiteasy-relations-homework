package com.example.techiteasyhomework.controllers;

import com.example.techiteasyhomework.dtos.TelevisionInputDto;
import com.example.techiteasyhomework.dtos.TelevisionOutputDto;
import com.example.techiteasyhomework.models.Television;
import com.example.techiteasyhomework.services.TelevisionService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/televisions")
public class TelevisionController {

    private final TelevisionService televisionService;

    public TelevisionController(TelevisionService televisionService) {
        this.televisionService = televisionService;
    }

    @PostMapping
    public ResponseEntity<TelevisionOutputDto> createTelevision(@Valid @RequestBody TelevisionInputDto televisionInputDto) {
        TelevisionOutputDto t = televisionService.createTelevision(televisionInputDto);
        URI uri = URI.create(ServletUriComponentsBuilder
                .fromCurrentRequest().path("/" + t.getId()).toUriString());
        return ResponseEntity.created(uri).body(t);
    }

    @GetMapping
    public ResponseEntity<List<TelevisionOutputDto>> getAllTelevisions() {
        return ResponseEntity.ok().body(televisionService.getAllTelevisions());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TelevisionOutputDto> getTelevision(@PathVariable("id") Long id) {
        return ResponseEntity.ok().body(televisionService.getTelevisionById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Television> deleteTelevision(@PathVariable Long id) {
        televisionService.deleteTelevision(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<TelevisionOutputDto> updateTelevision(@PathVariable("id") Long id, @Valid @RequestBody TelevisionInputDto updatedTelevision) {
        TelevisionOutputDto t = televisionService.updateTelevision(id, updatedTelevision);
        return ResponseEntity.ok().body(t);
    }
}
