package eng.elemar.ponto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import eng.elemar.ponto.exceptions.BusinessException;
import eng.elemar.ponto.exceptions.NotFoundException;
import eng.elemar.ponto.mapper.MapperUtil;
import eng.elemar.ponto.model.TipoTelefone;
import eng.elemar.ponto.model.dto.TipoTelefoneDTO;
import eng.elemar.ponto.repository.TipoTelefoneRepository;
import eng.elemar.ponto.utils.MessageUtils;

@Service
public class TipoTelefoneService {

    @Autowired
    private TipoTelefoneRepository repository;

    @Autowired
    private MapperUtil mapper;

    @Transactional
    public TipoTelefoneDTO save(TipoTelefoneDTO dto) {
        TipoTelefone TipoTelefone = mapper.mapTo(dto, TipoTelefone.class);
        repository.save(TipoTelefone);
        return mapper.mapTo(TipoTelefone, TipoTelefoneDTO.class);
    }

    @Transactional
    public TipoTelefoneDTO update(TipoTelefoneDTO dto) {
        Optional<TipoTelefone> optionalTipoTelefone = repository.findById(dto.getId());
        if (!optionalTipoTelefone.isPresent()) {
            throw new BusinessException(MessageUtils.ENTITY_NOT_EXISTS);
        }
        TipoTelefone TipoTelefone = mapper.mapTo(dto, TipoTelefone.class);
        repository.save(TipoTelefone);
        return mapper.mapTo(TipoTelefone, TipoTelefoneDTO.class);
    }

    @Transactional(readOnly = true)
    public List<TipoTelefoneDTO> findAll() {
        List<TipoTelefone> list = repository.findAll();
        return mapper.mapList(list, TipoTelefoneDTO.class);
    }

    @Transactional(readOnly = true)
    public TipoTelefoneDTO findById(Long id) {
        TipoTelefone TipoTelefone = repository.findById(id).orElseThrow(NotFoundException::new);
        return mapper.mapTo(TipoTelefone, TipoTelefoneDTO.class);
    }

}
