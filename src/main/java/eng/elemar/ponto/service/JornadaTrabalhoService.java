package eng.elemar.ponto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import eng.elemar.ponto.exceptions.BusinessException;
import eng.elemar.ponto.exceptions.NotFoundException;
import eng.elemar.ponto.mapper.MapperUtil;
import eng.elemar.ponto.model.JornadaTrabalho;
import eng.elemar.ponto.model.dto.JornadaTrabalhoDTO;
import eng.elemar.ponto.repository.JornadaTrabalhoRepository;
import eng.elemar.ponto.utils.MessageUtils;

@Service
public class JornadaTrabalhoService {

    @Autowired
    private JornadaTrabalhoRepository repository;

    @Autowired
    private MapperUtil mapper;

    @Transactional
    public JornadaTrabalhoDTO save(JornadaTrabalhoDTO dto) {
        JornadaTrabalho JornadaTrabalho = mapper.mapTo(dto, JornadaTrabalho.class);
        repository.save(JornadaTrabalho);
        return mapper.mapTo(JornadaTrabalho, JornadaTrabalhoDTO.class);
    }

    @Transactional
    public JornadaTrabalhoDTO update(JornadaTrabalhoDTO dto) {
        Optional<JornadaTrabalho> optionalJornadaTrabalho = repository.findById(dto.getId());
        if (!optionalJornadaTrabalho.isPresent()) {
            throw new BusinessException(MessageUtils.ENTITY_NOT_EXISTS);
        }
        JornadaTrabalho JornadaTrabalho = mapper.mapTo(dto, JornadaTrabalho.class);
        repository.save(JornadaTrabalho);
        return mapper.mapTo(JornadaTrabalho, JornadaTrabalhoDTO.class);
    }

    @Transactional(readOnly = true)
    public List<JornadaTrabalhoDTO> findAll() {
        List<JornadaTrabalho> list = repository.findAll();
        return mapper.mapList(list, JornadaTrabalhoDTO.class);
    }

    @Transactional(readOnly = true)
    public JornadaTrabalhoDTO findById(Long id) {
        JornadaTrabalho JornadaTrabalho = repository.findById(id).orElseThrow(NotFoundException::new);
        return mapper.mapTo(JornadaTrabalho, JornadaTrabalhoDTO.class);
    }

}
