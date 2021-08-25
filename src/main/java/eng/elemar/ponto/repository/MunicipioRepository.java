package eng.elemar.ponto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import eng.elemar.ponto.model.Municipio;

@Repository
public interface MunicipioRepository extends JpaRepository<Municipio, Long> {

}
