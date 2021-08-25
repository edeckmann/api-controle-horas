package eng.elemar.ponto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import eng.elemar.ponto.exceptions.BusinessException;
import eng.elemar.ponto.exceptions.NotFoundException;
import eng.elemar.ponto.mapper.MapperUtil;
import eng.elemar.ponto.model.TipoLogradouro;
import eng.elemar.ponto.model.dto.TipoLogradouroDTO;
import eng.elemar.ponto.repository.TipoLogradouroRepository;
import eng.elemar.ponto.utils.MessageUtils;

@Service
public class TipoLogradouroService {

    @Autowired
    private TipoLogradouroRepository repository;

    @Autowired
    private MapperUtil mapper;

    @Transactional
    public TipoLogradouroDTO save(TipoLogradouroDTO dto) {
        TipoLogradouro TipoLogradouro = mapper.mapTo(dto, TipoLogradouro.class);
        repository.save(TipoLogradouro);
        return mapper.mapTo(TipoLogradouro, TipoLogradouroDTO.class);
    }

    @Transactional
    public TipoLogradouroDTO update(TipoLogradouroDTO dto) {
        Optional<TipoLogradouro> optionalTipoLogradouro = repository.findById(dto.getId());
        if (!optionalTipoLogradouro.isPresent()) {
            throw new BusinessException(MessageUtils.ENTITY_NOT_EXISTS);
        }
        TipoLogradouro TipoLogradouro = mapper.mapTo(dto, TipoLogradouro.class);
        repository.save(TipoLogradouro);
        return mapper.mapTo(TipoLogradouro, TipoLogradouroDTO.class);
    }

    @Transactional(readOnly = true)
    public List<TipoLogradouroDTO> findAll() {
        List<TipoLogradouro> list = repository.findAll();
        return mapper.mapList(list, TipoLogradouroDTO.class);
    }

    @Transactional(readOnly = true)
    public TipoLogradouroDTO findById(Long id) {
        TipoLogradouro TipoLogradouro = repository.findById(id).orElseThrow(NotFoundException::new);
        return mapper.mapTo(TipoLogradouro, TipoLogradouroDTO.class);
    }

}
