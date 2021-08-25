package eng.elemar.ponto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import eng.elemar.ponto.exceptions.BusinessException;
import eng.elemar.ponto.exceptions.NotFoundException;
import eng.elemar.ponto.mapper.MapperUtil;
import eng.elemar.ponto.model.BancoHoras;
import eng.elemar.ponto.model.dto.BancoHorasDTO;
import eng.elemar.ponto.model.dto.BancoHorasDTO.BancoHorasId;
import eng.elemar.ponto.repository.BancoHorasRepository;
import eng.elemar.ponto.utils.MessageUtils;

@Service
public class BancoHorasService {

    @Autowired
    private BancoHorasRepository repository;

    @Autowired
    private MapperUtil mapper;

    @Transactional
    public BancoHorasDTO save(BancoHorasDTO dto) {
        Optional<BancoHoras> optionalBancoHoras = repository.findBydataTrabalhada(dto.getDataTrabalhada());
        if (optionalBancoHoras.isPresent()) {
            throw new BusinessException(MessageUtils.ENTITY_ALREADY_EXISTS);
        }
        BancoHoras bancoHoras = mapper.mapTo(dto, BancoHoras.class);
        repository.save(bancoHoras);
        return mapper.mapTo(bancoHoras, BancoHorasDTO.class);
    }

    // @Transactional
    // public BancoHorasDTO update(BancoHorasDTO dto) {
    //     Optional<BancoHoras> optionalBancoHoras = repository.findByBancoHorasUpdate(dto.getId(),
    //             dto.getDataTrabalhada());
    //     if (optionalBancoHoras.isPresent()) {
    //         throw new BusinessException(MessageUtils.ENTITY_ALREADY_EXISTS);
    //     }
    //     BancoHoras bancoHoras = mapper.mapTo(dto, BancoHoras.class);
    //     repository.save(bancoHoras);
    //     return mapper.mapTo(bancoHoras, BancoHorasDTO.class);
    // }

    @Transactional(readOnly = true)
    public List<BancoHorasDTO> findAll() {
        List<BancoHoras> list = repository.findAll();
        return mapper.mapList(list, BancoHorasDTO.class);
    }

    @Transactional(readOnly = true)
    public BancoHorasDTO findById(BancoHorasId id) {
        BancoHoras bancoHoras = repository.findById(id).orElseThrow(NotFoundException::new);
        return mapper.mapTo(bancoHoras, BancoHorasDTO.class);
    }

    @Transactional
    public BancoHorasDTO delete(BancoHorasId id) {
        BancoHorasDTO dto = findById(id);
        repository.deleteById(dto.getId());
        return dto;
    }


}
