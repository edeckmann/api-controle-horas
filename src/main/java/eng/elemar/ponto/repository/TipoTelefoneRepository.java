package eng.elemar.ponto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import eng.elemar.ponto.model.TipoTelefone;

@Repository
public interface TipoTelefoneRepository extends JpaRepository<TipoTelefone, Long> {

}
