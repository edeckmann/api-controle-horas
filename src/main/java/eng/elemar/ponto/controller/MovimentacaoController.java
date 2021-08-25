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

import eng.elemar.ponto.model.dto.MovimentacaoDTO;
import eng.elemar.ponto.model.dto.MovimentacaoDTO.MovimentacaoId;
import eng.elemar.ponto.service.MovimentacaoService;

@RestController
@RequestMapping(value = "/Movimentacao")
public class MovimentacaoController {

    @Autowired
    private MovimentacaoService service;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MovimentacaoDTO> save(@RequestBody MovimentacaoDTO dto){
        return ResponseEntity.ok(service.save(dto));
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MovimentacaoDTO> update(@RequestBody MovimentacaoDTO dto){
        return ResponseEntity.ok(service.update(dto));
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<MovimentacaoDTO>> findAll(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MovimentacaoDTO> findById(@PathVariable MovimentacaoId id){
        return ResponseEntity.ok(service.findById(id));
    }


}
