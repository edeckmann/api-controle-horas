package eng.elemar.ponto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import eng.elemar.ponto.exceptions.BusinessException;
import eng.elemar.ponto.exceptions.NotFoundException;
import eng.elemar.ponto.mapper.MapperUtil;
import eng.elemar.ponto.model.CategoriaUsuario;
import eng.elemar.ponto.model.dto.CategoriaUsuarioDTO;
import eng.elemar.ponto.repository.CategoriaUsuarioRepository;
import eng.elemar.ponto.utils.MessageUtils;

@Service
public class CategoriaUsuarioService {

    @Autowired
    private CategoriaUsuarioRepository repository;

    @Autowired
    private MapperUtil mapper;

    @Transactional
    public CategoriaUsuarioDTO save(CategoriaUsuarioDTO dto) {
        CategoriaUsuario CategoriaUsuario = mapper.mapTo(dto, CategoriaUsuario.class);
        repository.save(CategoriaUsuario);
        return mapper.mapTo(CategoriaUsuario, CategoriaUsuarioDTO.class);
    }

    @Transactional
    public CategoriaUsuarioDTO update(CategoriaUsuarioDTO dto) {
        Optional<CategoriaUsuario> optionalCategoriaUsuario = repository.findById(dto.getId());
        if (!optionalCategoriaUsuario.isPresent()) {
            throw new BusinessException(MessageUtils.ENTITY_NOT_EXISTS);
        }
        CategoriaUsuario CategoriaUsuario = mapper.mapTo(dto, CategoriaUsuario.class);
        repository.save(CategoriaUsuario);
        return mapper.mapTo(CategoriaUsuario, CategoriaUsuarioDTO.class);
    }

    @Transactional(readOnly = true)
    public List<CategoriaUsuarioDTO> findAll() {
        List<CategoriaUsuario> list = repository.findAll();
        return mapper.mapList(list, CategoriaUsuarioDTO.class);
    }

    @Transactional(readOnly = true)
    public CategoriaUsuarioDTO findById(Long id) {
        CategoriaUsuario CategoriaUsuario = repository.findById(id).orElseThrow(NotFoundException::new);
        return mapper.mapTo(CategoriaUsuario, CategoriaUsuarioDTO.class);
    }

}
