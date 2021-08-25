package eng.elemar.ponto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import eng.elemar.ponto.exceptions.BusinessException;
import eng.elemar.ponto.exceptions.NotFoundException;
import eng.elemar.ponto.mapper.MapperUtil;
import eng.elemar.ponto.model.Municipio;
import eng.elemar.ponto.model.dto.MunicipioDTO;
import eng.elemar.ponto.repository.MunicipioRepository;
import eng.elemar.ponto.utils.MessageUtils;

@Service
public class MunicipioService {

    @Autowired
    private MunicipioRepository repository;

    @Autowired
    private MapperUtil mapper;

    @Transactional
    public MunicipioDTO save(MunicipioDTO dto) {
        Municipio Municipio = mapper.mapTo(dto, Municipio.class);
        repository.save(Municipio);
        return mapper.mapTo(Municipio, MunicipioDTO.class);
    }

    @Transactional
    public MunicipioDTO update(MunicipioDTO dto) {
        Optional<Municipio> optionalMunicipio = repository.findById(dto.getId());
        if (!optionalMunicipio.isPresent()) {
            throw new BusinessException(MessageUtils.ENTITY_NOT_EXISTS);
        }
        Municipio Municipio = mapper.mapTo(dto, Municipio.class);
        repository.save(Municipio);
        return mapper.mapTo(Municipio, MunicipioDTO.class);
    }

    @Transactional(readOnly = true)
    public List<MunicipioDTO> findAll() {
        List<Municipio> list = repository.findAll();
        return mapper.mapList(list, MunicipioDTO.class);
    }

    @Transactional(readOnly = true)
    public MunicipioDTO findById(Long id) {
        Municipio Municipio = repository.findById(id).orElseThrow(NotFoundException::new);
        return mapper.mapTo(Municipio, MunicipioDTO.class);
    }

}
