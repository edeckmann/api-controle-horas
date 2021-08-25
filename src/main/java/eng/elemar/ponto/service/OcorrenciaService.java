package eng.elemar.ponto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import eng.elemar.ponto.exceptions.BusinessException;
import eng.elemar.ponto.exceptions.NotFoundException;
import eng.elemar.ponto.mapper.MapperUtil;
import eng.elemar.ponto.model.Ocorrencia;
import eng.elemar.ponto.model.dto.OcorrenciaDTO;
import eng.elemar.ponto.repository.OcorrenciaRepository;
import eng.elemar.ponto.utils.MessageUtils;

@Service
public class OcorrenciaService {

    @Autowired
    private OcorrenciaRepository repository;

    @Autowired
    private MapperUtil mapper;

    @Transactional
    public OcorrenciaDTO save(OcorrenciaDTO dto) {
        Ocorrencia Ocorrencia = mapper.mapTo(dto, Ocorrencia.class);
        repository.save(Ocorrencia);
        return mapper.mapTo(Ocorrencia, OcorrenciaDTO.class);
    }

    @Transactional
    public OcorrenciaDTO update(OcorrenciaDTO dto) {
        Optional<Ocorrencia> optionalOcorrencia = repository.findById(dto.getId());
        if (!optionalOcorrencia.isPresent()) {
            throw new BusinessException(MessageUtils.ENTITY_NOT_EXISTS);
        }
        Ocorrencia Ocorrencia = mapper.mapTo(dto, Ocorrencia.class);
        repository.save(Ocorrencia);
        return mapper.mapTo(Ocorrencia, OcorrenciaDTO.class);
    }

    @Transactional(readOnly = true)
    public List<OcorrenciaDTO> findAll() {
        List<Ocorrencia> list = repository.findAll();
        return mapper.mapList(list, OcorrenciaDTO.class);
    }

    @Transactional(readOnly = true)
    public OcorrenciaDTO findById(Long id) {
        Ocorrencia Ocorrencia = repository.findById(id).orElseThrow(NotFoundException::new);
        return mapper.mapTo(Ocorrencia, OcorrenciaDTO.class);
    }

}
