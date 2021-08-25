package eng.elemar.ponto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import eng.elemar.ponto.exceptions.BusinessException;
import eng.elemar.ponto.exceptions.NotFoundException;
import eng.elemar.ponto.mapper.MapperUtil;
import eng.elemar.ponto.model.Pais;
import eng.elemar.ponto.model.dto.PaisDTO;
import eng.elemar.ponto.repository.PaisRepository;
import eng.elemar.ponto.utils.MessageUtils;

@Service
public class PaisService {

    @Autowired
    private PaisRepository repository;

    @Autowired
    private MapperUtil mapper;

    @Transactional
    public PaisDTO save(PaisDTO dto) {
        Pais Pais = mapper.mapTo(dto, Pais.class);
        repository.save(Pais);
        return mapper.mapTo(Pais, PaisDTO.class);
    }

    @Transactional
    public PaisDTO update(PaisDTO dto) {
        Optional<Pais> optionalPais = repository.findById(dto.getId());
        if (!optionalPais.isPresent()) {
            throw new BusinessException(MessageUtils.ENTITY_NOT_EXISTS);
        }
        Pais Pais = mapper.mapTo(dto, Pais.class);
        repository.save(Pais);
        return mapper.mapTo(Pais, PaisDTO.class);
    }

    @Transactional(readOnly = true)
    public List<PaisDTO> findAll() {
        List<Pais> list = repository.findAll();
        return mapper.mapList(list, PaisDTO.class);
    }

    @Transactional(readOnly = true)
    public PaisDTO findById(Long id) {
        Pais Pais = repository.findById(id).orElseThrow(NotFoundException::new);
        return mapper.mapTo(Pais, PaisDTO.class);
    }

}
