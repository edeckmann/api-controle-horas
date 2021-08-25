package eng.elemar.ponto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import eng.elemar.ponto.model.dto.LocalidadeDTO;
import eng.elemar.ponto.model.dto.LocalidadeDTO.LocalidadeId;
import eng.elemar.ponto.service.LocalidadeService;

@RestController
@RequestMapping(value = "/Localidade")
public class LocalidadeController {

    @Autowired
    private LocalidadeService service;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<LocalidadeDTO> save(@RequestBody LocalidadeDTO dto) {
        return ResponseEntity.ok(service.save(dto));
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<LocalidadeDTO> update(@RequestBody LocalidadeDTO dto) {
        return ResponseEntity.ok(service.update(dto));
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<LocalidadeDTO>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<LocalidadeDTO> findById(@PathVariable LocalidadeId id) {
        return ResponseEntity.ok(service.findById(id));
    }

}
