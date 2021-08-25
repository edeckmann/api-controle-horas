package eng.elemar.ponto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import eng.elemar.ponto.exceptions.BusinessException;
import eng.elemar.ponto.exceptions.NotFoundException;
import eng.elemar.ponto.mapper.MapperUtil;
import eng.elemar.ponto.model.Calendario;
import eng.elemar.ponto.model.dto.CalendarioDTO;
import eng.elemar.ponto.repository.CalendarioRepository;
import eng.elemar.ponto.utils.MessageUtils;

@Service
public class CalendarioService {

    @Autowired
    private CalendarioRepository repository;

    @Autowired
    private MapperUtil mapper;

    @Transactional
    public CalendarioDTO save(CalendarioDTO dto) {
        Calendario Calendario = mapper.mapTo(dto, Calendario.class);
        repository.save(Calendario);
        return mapper.mapTo(Calendario, CalendarioDTO.class);
    }

    @Transactional
    public CalendarioDTO update(CalendarioDTO dto) {
        Optional<Calendario> optionalCalendario = repository.findById(dto.getId());
        if (!optionalCalendario.isPresent()) {
            throw new BusinessException(MessageUtils.ENTITY_NOT_EXISTS);
        }
        Calendario Calendario = mapper.mapTo(dto, Calendario.class);
        repository.save(Calendario);
        return mapper.mapTo(Calendario, CalendarioDTO.class);
    }

    @Transactional(readOnly = true)
    public List<CalendarioDTO> findAll() {
        List<Calendario> list = repository.findAll();
        return mapper.mapList(list, CalendarioDTO.class);
    }

    @Transactional(readOnly = true)
    public CalendarioDTO findById(Long id) {
        Calendario Calendario = repository.findById(id).orElseThrow(NotFoundException::new);
        return mapper.mapTo(Calendario, CalendarioDTO.class);
    }

}
