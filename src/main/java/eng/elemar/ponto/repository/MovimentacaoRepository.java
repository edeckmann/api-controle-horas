package eng.elemar.ponto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import eng.elemar.ponto.model.Movimentacao;
import eng.elemar.ponto.model.dto.MovimentacaoDTO.MovimentacaoId;;

@Repository
public interface MovimentacaoRepository extends JpaRepository<Movimentacao, MovimentacaoId> {

}
