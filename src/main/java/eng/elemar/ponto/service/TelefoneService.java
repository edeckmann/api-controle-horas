package eng.elemar.ponto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import eng.elemar.ponto.exceptions.BusinessException;
import eng.elemar.ponto.exceptions.NotFoundException;
import eng.elemar.ponto.mapper.MapperUtil;
import eng.elemar.ponto.model.Telefone;
import eng.elemar.ponto.model.dto.TelefoneDTO;
import eng.elemar.ponto.repository.TelefoneRepository;
import eng.elemar.ponto.utils.MessageUtils;

@Service
public class TelefoneService {

    @Autowired
    private TelefoneRepository repository;

    @Autowired
    private MapperUtil mapper;

    @Transactional
    public TelefoneDTO save(TelefoneDTO dto) {
        Telefone Telefone = mapper.mapTo(dto, Telefone.class);
        repository.save(Telefone);
        return mapper.mapTo(Telefone, TelefoneDTO.class);
    }

    @Transactional
    public TelefoneDTO update(TelefoneDTO dto) {
        Optional<Telefone> optionalTelefone = repository.findById(dto.getId());
        if (!optionalTelefone.isPresent()) {
            throw new BusinessException(MessageUtils.ENTITY_NOT_EXISTS);
        }
        Telefone Telefone = mapper.mapTo(dto, Telefone.class);
        repository.save(Telefone);
        return mapper.mapTo(Telefone, TelefoneDTO.class);
    }

    @Transactional(readOnly = true)
    public List<TelefoneDTO> findAll() {
        List<Telefone> list = repository.findAll();
        return mapper.mapList(list, TelefoneDTO.class);
    }

    @Transactional(readOnly = true)
    public TelefoneDTO findById(Long id) {
        Telefone Telefone = repository.findById(id).orElseThrow(NotFoundException::new);
        return mapper.mapTo(Telefone, TelefoneDTO.class);
    }

}
