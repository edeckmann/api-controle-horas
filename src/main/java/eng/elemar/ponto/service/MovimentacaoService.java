package eng.elemar.ponto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import eng.elemar.ponto.exceptions.BusinessException;
import eng.elemar.ponto.exceptions.NotFoundException;
import eng.elemar.ponto.mapper.MapperUtil;
import eng.elemar.ponto.model.Movimentacao;
import eng.elemar.ponto.model.dto.MovimentacaoDTO;
import eng.elemar.ponto.model.dto.MovimentacaoDTO.MovimentacaoId;
import eng.elemar.ponto.repository.MovimentacaoRepository;
import eng.elemar.ponto.utils.MessageUtils;

@Service
public class MovimentacaoService {

    @Autowired
    private MovimentacaoRepository repository;

    @Autowired
    private MapperUtil mapper;

    @Transactional
    public MovimentacaoDTO save(MovimentacaoDTO dto) {
        Movimentacao Movimentacao = mapper.mapTo(dto, Movimentacao.class);
        repository.save(Movimentacao);
        return mapper.mapTo(Movimentacao, MovimentacaoDTO.class);
    }

    @Transactional
    public MovimentacaoDTO update(MovimentacaoDTO dto) {
        Optional<Movimentacao> optionalMovimentacao = repository.findById(dto.getId());
        if (!optionalMovimentacao.isPresent()) {
            throw new BusinessException(MessageUtils.ENTITY_NOT_EXISTS);
        }
        Movimentacao Movimentacao = mapper.mapTo(dto, Movimentacao.class);
        repository.save(Movimentacao);
        return mapper.mapTo(Movimentacao, MovimentacaoDTO.class);
    }

    @Transactional(readOnly = true)
    public List<MovimentacaoDTO> findAll() {
        List<Movimentacao> list = repository.findAll();
        return mapper.mapList(list, MovimentacaoDTO.class);
    }

    @Transactional(readOnly = true)
    public MovimentacaoDTO findById(MovimentacaoId id) {
        Movimentacao Movimentacao = repository.findById(id).orElseThrow(NotFoundException::new);
        return mapper.mapTo(Movimentacao, MovimentacaoDTO.class);
    }

}
