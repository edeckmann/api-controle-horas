package eng.elemar.ponto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import eng.elemar.ponto.exceptions.BusinessException;
import eng.elemar.ponto.exceptions.NotFoundException;
import eng.elemar.ponto.mapper.MapperUtil;
import eng.elemar.ponto.model.NivelAcesso;
import eng.elemar.ponto.model.dto.NivelAcessoDTO;
import eng.elemar.ponto.repository.NivelAcessoRepository;
import eng.elemar.ponto.utils.MessageUtils;

@Service
public class NivelAcessoService {

    @Autowired
    private NivelAcessoRepository repository;

    @Autowired
    private MapperUtil mapper;

    @Transactional
    public NivelAcessoDTO save(NivelAcessoDTO dto) {
        NivelAcesso NivelAcesso = mapper.mapTo(dto, NivelAcesso.class);
        repository.save(NivelAcesso);
        return mapper.mapTo(NivelAcesso, NivelAcessoDTO.class);
    }

    @Transactional
    public NivelAcessoDTO update(NivelAcessoDTO dto) {
        Optional<NivelAcesso> optionalNivelAcesso = repository.findById(dto.getId());
        if (!optionalNivelAcesso.isPresent()) {
            throw new BusinessException(MessageUtils.ENTITY_NOT_EXISTS);
        }
        NivelAcesso NivelAcesso = mapper.mapTo(dto, NivelAcesso.class);
        repository.save(NivelAcesso);
        return mapper.mapTo(NivelAcesso, NivelAcessoDTO.class);
    }

    @Transactional(readOnly = true)
    public List<NivelAcessoDTO> findAll() {
        List<NivelAcesso> list = repository.findAll();
        return mapper.mapList(list, NivelAcessoDTO.class);
    }

    @Transactional(readOnly = true)
    public NivelAcessoDTO findById(Long id) {
        NivelAcesso NivelAcesso = repository.findById(id).orElseThrow(NotFoundException::new);
        return mapper.mapTo(NivelAcesso, NivelAcessoDTO.class);
    }

}
