package com.caioosorio.radarius.controllers;

import com.caioosorio.radarius.dtos.detectedincident.DetectedIncidentRequestDTO;
import com.caioosorio.radarius.dtos.detectedincident.DetectedIncidentResponseDTO;
import com.caioosorio.radarius.services.DetectedIncidentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/detected-incidents")
public class DetectedIncidentController {

    private final DetectedIncidentService service;

    public DetectedIncidentController(DetectedIncidentService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<DetectedIncidentResponseDTO>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetectedIncidentResponseDTO> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<DetectedIncidentResponseDTO> create(@RequestBody DetectedIncidentRequestDTO dto) {
        return ResponseEntity.ok(service.save(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DetectedIncidentResponseDTO> update(@PathVariable Integer id,
                                                              @RequestBody DetectedIncidentRequestDTO dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
