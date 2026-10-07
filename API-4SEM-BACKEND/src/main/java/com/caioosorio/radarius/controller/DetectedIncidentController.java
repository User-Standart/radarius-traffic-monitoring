package com.caioosorio.radarius.controller;

import com.caioosorio.radarius.dto.detectedincident.DetectedIncidentRequestDTO;
import com.caioosorio.radarius.dto.detectedincident.DetectedIncidentResponseDTO;
import com.caioosorio.radarius.service.DetectedIncidentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/detected-incidents")
public class DetectedIncidentController {

    @Autowired
    private DetectedIncidentService detectedIncidentService;

    @PostMapping
    public ResponseEntity<DetectedIncidentResponseDTO> create(@RequestBody DetectedIncidentRequestDTO dto) {
        return ResponseEntity.ok(detectedIncidentService.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DetectedIncidentResponseDTO> update(@PathVariable Integer id, @RequestBody DetectedIncidentRequestDTO dto) {
        return ResponseEntity.ok(detectedIncidentService.update(id, dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetectedIncidentResponseDTO> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(detectedIncidentService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<DetectedIncidentResponseDTO>> findAll() {
        return ResponseEntity.ok(detectedIncidentService.findAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        detectedIncidentService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
