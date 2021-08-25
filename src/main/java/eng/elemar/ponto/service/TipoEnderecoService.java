package eng.elemar.ponto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import eng.elemar.ponto.exceptions.BusinessException;
import eng.elemar.ponto.exceptions.NotFoundException;
import eng.elemar.ponto.mapper.MapperUtil;
import eng.elemar.ponto.model.TipoEndereco;
import eng.elemar.ponto.model.dto.TipoEnderecoDTO;
import eng.elemar.ponto.repository.TipoEnderecoRepository;
import eng.elemar.ponto.utils.MessageUtils;

@Service
public class TipoEnderecoService {

    @Autowired
    private TipoEnderecoRepository repository;

    @Autowired
    private MapperUtil mapper;

    @Transactional
    public TipoEnderecoDTO save(TipoEnderecoDTO dto) {
        TipoEndereco TipoEndereco = mapper.mapTo(dto, TipoEndereco.class);
        repository.save(TipoEndereco);
        return mapper.mapTo(TipoEndereco, TipoEnderecoDTO.class);
    }

    @Transactional
    public TipoEnderecoDTO update(TipoEnderecoDTO dto) {
        Optional<TipoEndereco> optionalTipoEndereco = repository.findById(dto.getId());
        if (!optionalTipoEndereco.isPresent()) {
            throw new BusinessException(MessageUtils.ENTITY_NOT_EXISTS);
        }
        TipoEndereco TipoEndereco = mapper.mapTo(dto, TipoEndereco.class);
        repository.save(TipoEndereco);
        return mapper.mapTo(TipoEndereco, TipoEnderecoDTO.class);
    }

    @Transactional(readOnly = true)
    public List<TipoEnderecoDTO> findAll() {
        List<TipoEndereco> list = repository.findAll();
        return mapper.mapList(list, TipoEnderecoDTO.class);
    }

    @Transactional(readOnly = true)
    public TipoEnderecoDTO findById(Long id) {
        TipoEndereco TipoEndereco = repository.findById(id).orElseThrow(NotFoundException::new);
        return mapper.mapTo(TipoEndereco, TipoEnderecoDTO.class);
    }

}
