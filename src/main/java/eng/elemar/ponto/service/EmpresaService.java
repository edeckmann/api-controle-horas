package eng.elemar.ponto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import eng.elemar.ponto.exceptions.BusinessException;
import eng.elemar.ponto.exceptions.NotFoundException;
import eng.elemar.ponto.mapper.MapperUtil;
import eng.elemar.ponto.model.Empresa;
import eng.elemar.ponto.model.dto.EmpresaDTO;
import eng.elemar.ponto.repository.EmpresaRepository;
import eng.elemar.ponto.utils.MessageUtils;

@Service
public class EmpresaService {

    @Autowired
    private EmpresaRepository repository;

    @Autowired
    private MapperUtil mapper;

    @Transactional
    public EmpresaDTO save(EmpresaDTO dto) {
        Empresa Empresa = mapper.mapTo(dto, Empresa.class);
        repository.save(Empresa);
        return mapper.mapTo(Empresa, EmpresaDTO.class);
    }

    @Transactional
    public EmpresaDTO update(EmpresaDTO dto) {
        Optional<Empresa> optionalEmpresa = repository.findById(dto.getId());
        if (!optionalEmpresa.isPresent()) {
            throw new BusinessException(MessageUtils.ENTITY_NOT_EXISTS);
        }
        Empresa Empresa = mapper.mapTo(dto, Empresa.class);
        repository.save(Empresa);
        return mapper.mapTo(Empresa, EmpresaDTO.class);
    }

    @Transactional(readOnly = true)
    public List<EmpresaDTO> findAll() {
        List<Empresa> list = repository.findAll();
        return mapper.mapList(list, EmpresaDTO.class);
    }

    @Transactional(readOnly = true)
    public EmpresaDTO findById(Long id) {
        Empresa Empresa = repository.findById(id).orElseThrow(NotFoundException::new);
        return mapper.mapTo(Empresa, EmpresaDTO.class);
    }

}
