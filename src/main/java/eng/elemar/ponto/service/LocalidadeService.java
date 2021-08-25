package eng.elemar.ponto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import eng.elemar.ponto.exceptions.BusinessException;
import eng.elemar.ponto.exceptions.NotFoundException;
import eng.elemar.ponto.mapper.MapperUtil;
import eng.elemar.ponto.model.Localidade;
import eng.elemar.ponto.model.dto.LocalidadeDTO;
import eng.elemar.ponto.model.dto.LocalidadeDTO.LocalidadeId;
import eng.elemar.ponto.repository.LocalidadeRepository;
import eng.elemar.ponto.utils.MessageUtils;

@Service
public class LocalidadeService {

    @Autowired
    private LocalidadeRepository repository;

    @Autowired
    private MapperUtil mapper;

    @Transactional
    public LocalidadeDTO save(LocalidadeDTO dto) {
        Localidade Localidade = mapper.mapTo(dto, Localidade.class);
        repository.save(Localidade);
        return mapper.mapTo(Localidade, LocalidadeDTO.class);
    }

    @Transactional
    public LocalidadeDTO update(LocalidadeDTO dto) {
        Optional<Localidade> optionalLocalidade = repository.findById(dto.getId());
        if (!optionalLocalidade.isPresent()) {
            throw new BusinessException(MessageUtils.ENTITY_NOT_EXISTS);
        }
        Localidade Localidade = mapper.mapTo(dto, Localidade.class);
        repository.save(Localidade);
        return mapper.mapTo(Localidade, LocalidadeDTO.class);
    }

    @Transactional(readOnly = true)
    public List<LocalidadeDTO> findAll() {
        List<Localidade> list = repository.findAll();
        return mapper.mapList(list, LocalidadeDTO.class);
    }

    @Transactional(readOnly = true)
    public LocalidadeDTO findById(LocalidadeId id){
        Localidade localidade = repository.findById(id).orElseThrow(NotFoundException::new);
        return mapper.mapTo(localidade, LocalidadeDTO.class);
    }


}
