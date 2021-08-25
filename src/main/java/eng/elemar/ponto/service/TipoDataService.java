package eng.elemar.ponto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import eng.elemar.ponto.exceptions.BusinessException;
import eng.elemar.ponto.exceptions.NotFoundException;
import eng.elemar.ponto.mapper.MapperUtil;
import eng.elemar.ponto.model.TipoData;
import eng.elemar.ponto.model.dto.TipoDataDTO;
import eng.elemar.ponto.repository.TipoDataRepository;
import eng.elemar.ponto.utils.MessageUtils;

@Service
public class TipoDataService {

    @Autowired
    private TipoDataRepository repository;

    @Autowired
    private MapperUtil mapper;

    @Transactional
    public TipoDataDTO save(TipoDataDTO dto) {
        TipoData TipoData = mapper.mapTo(dto, TipoData.class);
        repository.save(TipoData);
        return mapper.mapTo(TipoData, TipoDataDTO.class);
    }

    @Transactional
    public TipoDataDTO update(TipoDataDTO dto) {
        Optional<TipoData> optionalTipoData = repository.findById(dto.getId());
        if (!optionalTipoData.isPresent()) {
            throw new BusinessException(MessageUtils.ENTITY_NOT_EXISTS);
        }
        TipoData TipoData = mapper.mapTo(dto, TipoData.class);
        repository.save(TipoData);
        return mapper.mapTo(TipoData, TipoDataDTO.class);
    }

    @Transactional(readOnly = true)
    public List<TipoDataDTO> findAll() {
        List<TipoData> list = repository.findAll();
        return mapper.mapList(list, TipoDataDTO.class);
    }

    @Transactional(readOnly = true)
    public TipoDataDTO findById(Long id) {
        TipoData TipoData = repository.findById(id).orElseThrow(NotFoundException::new);
        return mapper.mapTo(TipoData, TipoDataDTO.class);
    }

}
