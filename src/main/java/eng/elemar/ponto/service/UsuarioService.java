package eng.elemar.ponto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import eng.elemar.ponto.exceptions.BusinessException;
import eng.elemar.ponto.exceptions.NotFoundException;
import eng.elemar.ponto.mapper.MapperUtil;
import eng.elemar.ponto.model.Usuario;
import eng.elemar.ponto.model.dto.UsuarioDTO;
import eng.elemar.ponto.repository.UsuarioRepository;
import eng.elemar.ponto.utils.MessageUtils;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    @Autowired
    private MapperUtil mapper;

    @Transactional
    public UsuarioDTO save(UsuarioDTO dto) {
        Usuario Usuario = mapper.mapTo(dto, Usuario.class);
        repository.save(Usuario);
        return mapper.mapTo(Usuario, UsuarioDTO.class);
    }

    @Transactional
    public UsuarioDTO update(UsuarioDTO dto) {
        Optional<Usuario> optionalUsuario = repository.findById(dto.getId());
        if (!optionalUsuario.isPresent()) {
            throw new BusinessException(MessageUtils.ENTITY_NOT_EXISTS);
        }
        Usuario Usuario = mapper.mapTo(dto, Usuario.class);
        repository.save(Usuario);
        return mapper.mapTo(Usuario, UsuarioDTO.class);
    }

    @Transactional(readOnly = true)
    public List<UsuarioDTO> findAll() {
        List<Usuario> list = repository.findAll();
        return mapper.mapList(list, UsuarioDTO.class);
    }

    @Transactional(readOnly = true)
    public UsuarioDTO findById(Long id) {
        Usuario Usuario = repository.findById(id).orElseThrow(NotFoundException::new);
        return mapper.mapTo(Usuario, UsuarioDTO.class);
    }

}
