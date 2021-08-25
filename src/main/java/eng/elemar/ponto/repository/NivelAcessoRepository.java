package eng.elemar.ponto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import eng.elemar.ponto.model.NivelAcesso;

@Repository
public interface NivelAcessoRepository extends JpaRepository<NivelAcesso, Long> {

}
