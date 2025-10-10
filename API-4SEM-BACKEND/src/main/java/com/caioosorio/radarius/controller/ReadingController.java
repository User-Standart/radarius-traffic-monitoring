package com.caioosorio.radarius.controller;

import com.caioosorio.radarius.dto.reading.ReadingRequestDTO;
import com.caioosorio.radarius.dto.reading.ReadingResponseDTO;
import com.caioosorio.radarius.service.ReadingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/readings")
public class ReadingController {

    @Autowired
    private ReadingService readingService;

    @PostMapping
    public ResponseEntity<ReadingResponseDTO> create(@RequestBody ReadingRequestDTO dto) {
        return ResponseEntity.ok(readingService.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReadingResponseDTO> update(@PathVariable Integer id, @RequestBody ReadingRequestDTO dto) {
        return ResponseEntity.ok(readingService.update(id, dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReadingResponseDTO> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(readingService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<ReadingResponseDTO>> findAll() {
        return ResponseEntity.ok(readingService.findAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        readingService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
