package eng.elemar.ponto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import eng.elemar.ponto.model.Localidade;
import eng.elemar.ponto.model.dto.LocalidadeDTO.LocalidadeId;;

@Repository
public interface LocalidadeRepository extends JpaRepository<Localidade, LocalidadeId> {

}
