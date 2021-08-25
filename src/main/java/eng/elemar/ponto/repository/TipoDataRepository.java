package eng.elemar.ponto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import eng.elemar.ponto.model.TipoData;

@Repository
public interface TipoDataRepository extends JpaRepository<TipoData, Long> {

}
