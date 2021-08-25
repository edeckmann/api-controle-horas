package eng.elemar.ponto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import eng.elemar.ponto.model.dto.BancoHorasDTO;
import eng.elemar.ponto.model.dto.BancoHorasDTO.BancoHorasId;
import eng.elemar.ponto.service.BancoHorasService;

@RestController
@RequestMapping(value = "/bancoHoras")
public class BancoHorasController {

    @Autowired
    private BancoHorasService service;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BancoHorasDTO> save(@RequestBody BancoHorasDTO dto) {
        return ResponseEntity.ok(service.save(dto));
    }

    // @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    // public ResponseEntity<BancoHorasDTO> update(@RequestBody BancoHorasDTO dto) {
    //     return ResponseEntity.ok(service.update(dto));
    // }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<BancoHorasDTO>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BancoHorasDTO> findById(@PathVariable BancoHorasId id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BancoHorasDTO> delete(@PathVariable BancoHorasId id) {
        return ResponseEntity.ok(service.delete(id));
    }

}
