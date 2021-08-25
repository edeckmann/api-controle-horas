package eng.elemar.ponto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import eng.elemar.ponto.exceptions.BusinessException;
import eng.elemar.ponto.exceptions.NotFoundException;
import eng.elemar.ponto.mapper.MapperUtil;
import eng.elemar.ponto.model.Estado;
import eng.elemar.ponto.model.dto.EstadoDTO;
import eng.elemar.ponto.repository.EstadoRepository;
import eng.elemar.ponto.utils.MessageUtils;

@Service
public class EstadoService {

    @Autowired
    private EstadoRepository repository;

    @Autowired
    private MapperUtil mapper;

    @Transactional
    public EstadoDTO save(EstadoDTO dto) {
        Estado Estado = mapper.mapTo(dto, Estado.class);
        repository.save(Estado);
        return mapper.mapTo(Estado, EstadoDTO.class);
    }

    @Transactional
    public EstadoDTO update(EstadoDTO dto) {
        Optional<Estado> optionalEstado = repository.findById(dto.getId());
        if (!optionalEstado.isPresent()) {
            throw new BusinessException(MessageUtils.ENTITY_NOT_EXISTS);
        }
        Estado Estado = mapper.mapTo(dto, Estado.class);
        repository.save(Estado);
        return mapper.mapTo(Estado, EstadoDTO.class);
    }

    @Transactional(readOnly = true)
    public List<EstadoDTO> findAll() {
        List<Estado> list = repository.findAll();
        return mapper.mapList(list, EstadoDTO.class);
    }

    @Transactional(readOnly = true)
    public EstadoDTO findById(Long id) {
        Estado Estado = repository.findById(id).orElseThrow(NotFoundException::new);
        return mapper.mapTo(Estado, EstadoDTO.class);
    }

}
