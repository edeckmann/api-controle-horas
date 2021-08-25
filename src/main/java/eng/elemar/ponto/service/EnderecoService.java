package eng.elemar.ponto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import eng.elemar.ponto.exceptions.BusinessException;
import eng.elemar.ponto.exceptions.NotFoundException;
import eng.elemar.ponto.mapper.MapperUtil;
import eng.elemar.ponto.model.Endereco;
import eng.elemar.ponto.model.dto.EnderecoDTO;
import eng.elemar.ponto.repository.EnderecoRepository;
import eng.elemar.ponto.utils.MessageUtils;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository repository;

    @Autowired
    private MapperUtil mapper;

    @Transactional
    public EnderecoDTO save(EnderecoDTO dto) {
        Endereco Endereco = mapper.mapTo(dto, Endereco.class);
        repository.save(Endereco);
        return mapper.mapTo(Endereco, EnderecoDTO.class);
    }

    @Transactional
    public EnderecoDTO update(EnderecoDTO dto) {
        Optional<Endereco> optionalEndereco = repository.findById(dto.getId());
        if (!optionalEndereco.isPresent()) {
            throw new BusinessException(MessageUtils.ENTITY_NOT_EXISTS);
        }
        Endereco Endereco = mapper.mapTo(dto, Endereco.class);
        repository.save(Endereco);
        return mapper.mapTo(Endereco, EnderecoDTO.class);
    }

    @Transactional(readOnly = true)
    public List<EnderecoDTO> findAll() {
        List<Endereco> list = repository.findAll();
        return mapper.mapList(list, EnderecoDTO.class);
    }

    @Transactional(readOnly = true)
    public EnderecoDTO findById(Long id) {
        Endereco Endereco = repository.findById(id).orElseThrow(NotFoundException::new);
        return mapper.mapTo(Endereco, EnderecoDTO.class);
    }

}
